"use strict"

window.addEventListener("DOMContentLoaded", function () {

    $("#submit-btn").attr("disabled", "disabled");

    $('#username, #email, #password, #confirmPassword').focusout(function () {
        let username = $("#username").val();
        let email = $("#email").val();
        let password = $("#password").val();
        let confirmPassword = $("#confirmPassword").val();

        if (username === "") {
            $("#usernameError").html("Please enter a valid username").css("color", "red");
        } else {
            $("#usernameError").html("");
        }

        if (email === "") {
            $("#emailError").html("Please enter a valid email address").css("color", "red");
        } else {
            $("#emailError").html("");
        }

        if (password === "") {
            $("#passwordError").html("Please enter a password").css("color", "red");
        } else {
            $("#passwordError").html("");
        }

        if (confirmPassword === "") {
            $("#confirmPasswordError").html("Please confirm your password").css("color", "red");
        } else {
            $("#confirmPasswordError").html("");
        }

        if (password !== confirmPassword) {
            $("#passwordError").html("Passwords don't match").css("color", "red");
            $("#confirmPasswordError").html("Passwords don't match").css("color", "red");
        } else {
            $("#passwordError").html("");
            $("#confirmPasswordError").html("");
        }

        if ((username !== "" && email !== "" && password !== "" && confirmPassword !== "") && (password === confirmPassword)) {
            $("#submit-btn").removeAttr("disabled");
        } else {
            $("#submit-btn").attr("disabled", "disabled");
        }

    })

});