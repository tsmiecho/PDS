$(document).ready(function() {
    $('html, body').animate({
        scrollTop: $("#back-href").offset().top
    }, 2000);
});

$(document).ready(function () {
    window.setTimeout(function () {
        location.href = "/PersonalDataStorage/";
    }, 10000);
});