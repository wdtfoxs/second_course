$(document).ready(function () {
    $(document).on('click', '#addToCart', function () {
       event.preventDefault();
       var $this = $(this);
        $.ajax({
           type: 'POST',
           url: '/cart/add',
           data: {goodId: $this.data('id')},
           success: function (data, status) {  // успешное завершение работы
               $('#add_cart_' + $this.data('id')).text('✓ Товар добавлен').height(1);
               $.ajax({
                   type: 'POST',
                   url: '/cart/total'
               }).done(function (data) {
                   $('.cart_total').text('$' + data);
               });
               $.ajax({
                   type: 'POST',
                   url: '/cart/count'
               }).done(function (data) {
                   $('#cart_quantity').text(data);
               });
                console.log('/cart/add result: data=' + data + '; status=' + status);
            },
            error: function () {    // На сервере произошла ошибка
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
       });
   });

    $(document).on('click', '#delFromCart', function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/cart/del',
            data: {goodId: $this.data('id')},
            success: function(){
                var l = 0;
                while(l != 3) {
                    $('#' + $this.data('id')).remove();
                    l++;
                }
                $.ajax({
                    type: 'POST',
                    url: '/cart/total'
                }).done(function (data) {
                    $('.cart_total').text('$' + data);
                });
                $.ajax({
                    type: 'POST',
                    url: '/cart/count'
                }).done(function (data) {
                    $('#cart_quantity').text(data);
                });
            },
            error: function () {    // На сервере произошла ошибка
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });

    $(document).on('click', '#minus', function () {
        event.preventDefault();
        var id = $(this);
        $.ajax({
            type: 'POST',
            url: '/cart/minus',
            data: {goodId: id.data('id')}
        }).done(function (data) {
            $("#num_" + id.data('id')).text(data);
            $.ajax({
                type: 'POST',
                url: '/cart/total'
            }).done(function (data) {
                $('.cart_total').text('$' + data);
            });
            $.ajax({
                type: 'POST',
                url: '/cart/count'
            }).done(function (data) {
                $('#cart_quantity').text(data);
            });
        })
    });

    $(document).on('click', '#plus', function () {
        event.preventDefault();
        var id = $(this);
        $.ajax({
            type: 'POST',
            url: '/cart/plus',
            data: {goodId: id.data('id')}
        }).done(function (data) {
            $("#num_" + id.data('id')).text(data);
            $.ajax({
                type: 'POST',
                url: '/cart/total'
            }).done(function (data) {
                $('.cart_total').text('$' + data);
            });
            $.ajax({
                type: 'POST',
                url: '/cart/count'
            }).done(function (data) {
                $('#cart_quantity').text(data);
            });
        })
    });
    $(document).on('click', '.cart', function () {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: '/cart/empty'
        });
        $.ajax({
            type: 'POST',
            url: '/cart/total'
        }).done(function (data) {
            $('.cart_total').text('$' + data);
        });
        $.ajax({
            type: 'POST',
            url: '/cart/count'
        }).done(function (data) {
            $('#cart_quantity').text(data);
        });
    });
});