const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const nodemailer = require('nodemailer');
const mysql = require('mysql');
const path = require('path');
const url = require('url');


const app = express();

app.use(bodyParser.urlencoded({ extended: true }));

app.use(bodyParser.json());

app.use(cors());


app.post('/send', (req, res) => {
    var { mailid, message } = req.body;  //post request mailID, message to be sent to :5000/send
    console.log(mailid, message);

    var mailOptions = {
        from: 'himanshuk2606@gmail.com',  //fill in the mailID after changing a setting in Google mail
        to: mailid,
        subject: 'Announcement',
        html: '<h1>Announcement!</h1><br/><h4>' + message + '</h4><br/>'
    };

    transporter.sendMail(mailOptions, function (error, info) {
        if (error) {
            console.log(error);
        } else {
            console.log('Email sent: ' + info.response);
        }
    });

    const abc = {
        res: result,
        error: err
    }

    res.json(JSON.stringify({ res: 1 }));
});



app.listen(process.env.PORT || 5000, () => {
    console.log("Port 5000");
})