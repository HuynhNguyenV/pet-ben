$(document).ready(function () {
    $('.nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        if (text == 'Edit') {
            $.get(href, function (product, status) {
                $('.myForm #id').val(product.id);
                $('.myForm #name').val(product.name);
                $('.myForm #price').val(product.price);
                $('.myForm #description').val(product.description);
                $('.myForm #image').val(product.image);
                $('.myForm #category').val(product.category.name);
            })
            $('.myForm #addPostModal').modal();
        } else {
            $('.myForm #id').val('')
            $('.myForm #name').val('');
            $('.myForm #price').val('');
            $('.myForm #description').val('');
            $('.myForm #image').val('');
            $('.myForm #category').val('');
        }
    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();
    })
});