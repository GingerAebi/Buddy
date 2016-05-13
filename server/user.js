var express = require('express');
var router = express.Router();
var db = require('./database');
router.post('/create', function(req, res) {
	
	req.accepts('application/json');
	console.log(req.body);
	
	var userInfo = [
		req.body.lastName,
		req.body.firstName,
	   	req.body.email,
   		req.body.password,
		req.body.userType
	]
	console.log(userInfo);
	db.get().query('SELECT * FROM user WHERE email = ?', req.body.email, function(err, result){	
		if(err) {
			console.log(err);
			res.send(err);
		}else if (result.length < 1) {
			insertUser(userInfo, res)
			return;
		}else {
			res.send("Email Already EXIST");
		}
	});
});

function insertUser(userInfo, res) {
	db.get().query('INSERT INTO user(lastName, firstName, email, password, userType) VALUES(?, ?, ?, ?, ?)',userInfo, function(err, result){
		if(err) {
			console.log(err);
		}else {
			console.log(result);
			makeDetail(result.insertId);
			res.send("Create User Success");
		}
		
	});
}

function makeDetail(id) {
	db.get().query('SELECT userType FROM user WHERE _id = ?', id, function(err, result) {
		if (err) {
			console.log(err);
		} else {
			if(result[0].userType == 1) {
				makeClient(id);
			} else {
				makeBuddy(id);
			}
		}	
	});
}

function makeClient(id) { 
	db.get().query('INSERT INTO client(userId) VALUES(?)', id, function(err, result) {
		if (err) {
			console.log(err);
		}else {
			console.log("make Client Id : " + result.insertId + "Success");
		}
	});
}

function makeBuddy(id) {
	db.get().query('INSERT INTO buddy(userId) VALUES(?)', id, function(err, result) {
		if (err) {
			console.log(err);
		} else {
			console.log("MAKE BUDDY SUCCESS & ID : "+ result.insertId);
		}
	});
}

router.post('/login', function(req, res) {
    var email = req.body.email;
    var password = req.body.password;
	db.get().query('SELECT * FROM user WHERE email = ?', email, function(err, result){
	//err don't catch TYPE ERROR ? 
		if(err) {
			console.log(err);
		} else if(result.length < 1) {
			res.send("NO EMAIL EXIST");
		} else {
			if (password === result[0].password) {
				res.send("login Success");
			}else {
				res.send("Wrong Password");
			}

		}
	});		
});

module.exports = router;
