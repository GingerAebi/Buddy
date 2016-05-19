var express = require('express');
var app = express();
var morgan = require('morgan');
var bodyParser = require('body-parser').urlencoded({extended: true});
var user_route = require('./user');
var db = require('./database');

db.createPool();

app.use(morgan('combined'));
app.use(bodyParser);
app.use('/user', user_route);

app.set('port', process.env.port || 3000);

app.post('/test',function(req, res){
	console.log("test in");
	res.send("test");
	console.log(req.body.test);
});

app.get('/buddy/findBuddy', function (req, res) {
    var favorites = req.query.favorites;
    findBuddy(favorites, res);
});

function findBuddy(favorites, res) {
    db.get().query('SELECT * from buddy WHERE ' + favorites[0] + '> 0 AND ' + favorites[1] + ' > 0 AND ' + favorites[2] + '> 0', function (err, result) {
        if (!err) {
            var stringJson = JSON.stringify(result);
            var jsonResult = JSON.parse(stringJson);

            var max = 0;
            var key = 0;
            for (var i = 0; i < jsonResult.length; i++) {
                var sum = 0;
                sum += (jsonResult[i])[favorites[0]];
                sum += (jsonResult[i])[favorites[1]];
                sum += (jsonResult[i])[favorites[2]];
                if (max < sum) {
                    max = sum;
                    key = i;
                }
            }
            res.json(jsonResult[key]);
        } else {
            console.log(err);
        }
    });
}

app.use(function (req, res) {
    res.type('text/plain');
    res.status('404');
    res.send('404 - Not Found');
});

app.use(function (err, req, res, next) {
    console.error(err.stack)
    res.type('text/plain');
    res.status('500');
    res.send('500 - Server Error');
});

app.listen(app.get('port'), function () {
    console.log('Express Started on http://localhost:' + app.get('port') + 'press Ctrl + C to exit');
});
