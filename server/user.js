var express = require('express');
var db = require('./database');
var uuid = require('node-uuid');
var router = express.Router();

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
			var responseJson = "Email Already Exist";
			res.send(JSON.stringify(responseJson));
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
			var responseJson = 	"Create User Success" ;
			
			var jsonString = JSON.stringify(responseJson);
			res.status(200).send(jsonString);
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
		if(err) {
			console.log(err);
		} else if(result.length < 1) {
			res.send(JSON.stringify("NO EMAIL EXIST"));
		} else {
			if (password === result[0].password) {
				var session = makeSession(result[0]._id);
				res.send(JSON.stringify(["Login_Success", session]));
			}else {
				res.send(JSON.stringify("Wrong Password"));
			}

		}
	});		
});

function  makeSession(id) {
	var sessionKey = uuid.v1();
	var insert = [sessionKey, id];
	db.get().query('INSERT INTO session(session, userId) VALUES(?, ?) ',insert,function(err,result){
		if(!err){	
			return sessionKey;
		}else {
			return err;
		}		
	});		
}



module.exports = router;




