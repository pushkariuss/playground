$(document).ready(function () {
    $('#random-string-button').click(function () {
        $.ajax({
            type: 'get',
            url: '/smp/random-string',
            success: function (data) {
                $('#random-string').html(data);
            }
        });
    });
});