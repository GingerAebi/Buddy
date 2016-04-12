var express = require('express');
var app = express();
var mysql = require('mysql');

app.set('port', process.env.port || 9000);

var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'next2014',
    database: 'naverCafe'
});

connection.connect(function (err) {
    if (err) {
        console.error('mysql connection error');
        console.error(err);
        throw err;
    }
});

app.get('/contents', function (req, res) {
  connection.query('SELECT * from contents', function (err, result) {
      if (!err) {
          console.log('request in');
          res.json(result);
      } else {
          console.log(err);
      }
  });
});


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
