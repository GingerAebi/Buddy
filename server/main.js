var express = require('express');
var app = express();
var mysql = require('mysql');
var morgan = require('morgan');
var bodyParser = require('body-parser').urlencoded({extended: true});

app.use(morgan('combined'));
app.use(bodyParser);

app.set('port', process.env.port || 3000);

var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'next2014',
    database: 'crescent'
});

connection.connect(function (err) {
    if (err) {
        console.error('mysql connection error');
        console.error(err);
        throw err;
    }
});

app.post('/test',function(req, res){
	console.log("test in");
	res.send("test");
	console.log(req.body.test);
});


app.post('/user/create', function(req, res) {
	var userInfo = [
	   	req.body.email,
   		req.body.password
	]
	connection.query('INSERT INTO user(email, password) VALUES(?, ?)',userInfo, function(err, result){
		if(err) {
			console.log(err);
		}else {
			res.send(result);
		}
		
	});
});

app.post('/user/login', function(req, res) {
    var email = req.body.email;
    var password = req.body.password;
});

app.get('/buddy/findBuddy', function (req, res) {
    var favorites = req.query.favorites;
    findBuddy(favorites, res);
});

function findBuddy(favorites, res) {
    connection.query('SELECT * from buddy WHERE ' + favorites[0] + '> 0 AND ' + favorites[1] + ' > 0 AND ' + favorites[2] + '> 0', function (err, result) {
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
