$(document).ready(function () {
    $('.nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        if (text == 'Edit') {
            $.get(href, function (category, status) {
                $('.myForm #id').val(category.id);
                $('.myForm #name').val(category.name);
            })
            $('.myForm #addCategoryModal').modal();
        } else {
            $('.myForm #id').val('');
            $('.myForm #name').val('');
        }
    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();
    })
})