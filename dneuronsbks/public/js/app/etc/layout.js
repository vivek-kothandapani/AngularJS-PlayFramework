$(document).ready(function() {
      
    $('#payment-api').click(function() {
        $(this).parent().addClass('active');
        $('#inline, #standard').parent().removeClass('active');
    });

    $('#inline:parent').click(function () {
        $(this).parent().addClass('active');
        $('#payment-api, #standard').parent().removeClass('active');
    });

    $('#standard:parent').click(function () {
        $(this).parent().addClass('active');
        $('#payment-api, #inline').parent().removeClass('active');
    });

    $('.btn-settings, #settings-overlay, #buyer-experience').click(function () {
        if ($('.btn-settings').hasClass('active')) {
            $('.btn-settings').removeClass('active');
            $('#settings-panel').slideToggle(300);
            $('#settings-panel .container, #settings-overlay').fadeOut(450);
            $('#buyer-experience').fadeOut(350);
        } else {
            $('.btn-settings').addClass('active');
            $('#settings-panel').slideToggle(400);
            $('#settings-panel .container, #settings-overlay').fadeIn(600);
            $('#buyer-experience').fadeIn(800);
        }

    });
    
    $('.btn-help, #help-popup.modal, #help-overlay, #help-popup #close, #help-popup .close').click(function() {
        $('#help-popup.modal, #help-overlay').fadeToggle(300);
    });
    
   $('#help-popup .modal-content, .btn-help').click(function (e) {e.stopPropagation();});
   
   var startPayMethod = getParameterByName('method');
   if (startPayMethod != "") {$('#'+startPayMethod).click();}
    
    if (localStorage != null && JSON != null) {
       if (localStorage['visited']) {
           $('.btn-settings').removeClass('active');
           $('#settings-panel').slideToggle(0);
           $('#settings-panel .container, #settings-overlay, #buyer-experience').fadeOut(0);
       } else {
          localStorage['visited'] = 1;
       }
    }

    if (window.location.hash !== "#/shop" && window.location.hash !== "#/complete" ) {
       // window.location = '/demo/#/shop';
    } else if (window.location.hash == '#/shop') {
        $("#product-selection").show();
        $("#checkout-process").hide();
    } else {
        $("#product-selection").hide();
        $("#checkout-process").show();
    }

});

window.onpopstate=function()
{
    if (window.location.hash == "#/shop") {
        $("#product-selection").show();
        $("#checkout-process").hide();
    }
}

function toggleCart(scope) {
    if (scope == "product") {
        $("#checkout-process").hide();
        $("#product-selection").fadeIn(300);
    } else {
        $("#product-selection").hide();
        $("#checkout-process").fadeIn(300);
    }
}

function showSpinner() {
    $('#spinner-container').show();
    $('#sections').css('opacity','0.75');
}

function dismissSpinner() {
    $('#spinner-container').hide();
    $('#sections').css('opacity','1');
}

function getParameterByName(name) {
    var match = RegExp('[?&]' + name + '=([^&]*)').exec(window.location.search);
    return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
}