"use strict";

$(function() {

    $('#getAll_btn').click(function() {

        $.ajax({
            aysnc: true,
            cache: false,
            dataType: 'json',
            error: function(jqXHR, textStatus, error) {
                console.log(error);
            },
            success: function(data, textStatus, jqXHR) {
                console.log('SUCCESS', data);
            },
            type: 'GET',
            url: 'http://localhost:8080/Eatery/rest/people/getAll'
        });
    });



    $('#addPerson_btn').click(function() {

        var dummyPerson = {
            "firstName": "AAAA",
            "lastName": "BBBB",
            "email": "contact@aol.com",
            "address1": "123 M St",
            "address2": "",
            "city": "Richmond",
            "zip": 23228,
            "state": "Virginia",
            "phone": "1234567809"
        };

        $.ajax({
            aysnc: true,
            cache: false,
            contentType: "application/json;charset=utf-8",
            dataType: 'json',
            data: JSON.stringify(dummyPerson),
            error: function(jqXHR, textStatus, error) {
                console.log(error);
            },
            success: function(data, textStatus, jqXHR) {
                console.log('SUCCESS', data);
            },
            type: 'POST',
            url: 'http://localhost:8080/Eatery/rest/people/add'
        });
    });

});
