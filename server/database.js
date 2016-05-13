var mysql = require('mysql');

var pool;

exports.createPool = function() {
	pool = mysql.createPool({
		host: 'localhost',
		user: 'root',
		password: 'next2014',
		database: 'crescent'
	});	
}

exports.get = function() {
	return pool;
}

