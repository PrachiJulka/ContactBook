$(function() {

    $('#login-form-link').click(function(e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-form-link').click(function(e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

});

function check() {
    var input = document.getElementById('confirm-pass').value;
    if (input != document.getElementById('pass').value) {
        /*input.setCustomValidity('Password Must be Matching.');*/
        alert("Password and Confirm Password should Match");
        return false;
    }

}