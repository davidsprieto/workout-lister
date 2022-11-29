"use strict"

window.addEventListener("DOMContentLoaded", function () {

    $("#submit-btn").attr("disabled", "disabled");

    $('#date, #title, #description').focusout(function () {
        let date = $("#date").val();
        let title = $("#title").val();
        let description = $("#description").val();

        if (date.length < 10) {
            $("#date-error").html("Please enter a date in the proper format").css("color", "red");
        } else {
            $("#date-error").html("");
        }

        if (title.length < 1) {
            $("#title-error").html("Please enter a title").css("color", "red");
        } else {
            $("#title-error").html("");
        }

        if (description.length < 1) {
            $("#description-error").html("Please enter a description").css("color", "red");
        } else {
            $("#description-error").html("");
        }

        if (date.length >= 10 && title.length > 1 && description.length > 1) {
            $("#submit-btn").removeAttr("disabled");
        } else {
            $("#submit-btn").attr("disabled", "disabled");
        }

    })

});