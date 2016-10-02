function shoppingCart(cartName) {
    this.cartName = cartName;
    this.clearCart = false;
    this.checkoutParameters = {};
    this.showShipping = false;
    this.items = [];
    this.billing = {
        name: "Testing Tester",
        address1: "123 Test St",
        address2: "",
        city: "Columbus",
        state: "Ohio",
        zip: "43123",
        country: "USA",
        phone: "555-555-5555",
        phoneExt: "",
        email: "noreply@2co.com"
    };
    this.shipping = {
        name: "Testing Tester",
        address1: "123 Test St",
        address2: "",
        city: "Columbus",
        state: "Ohio",
        zip: "43123",
        country: "USA",
        phone: "555-555-5555",
        phoneExt: "",
        email: "noreply@2co.com"
    };
    this.copyAddress = false;
    this.shippingCost = "0.00";
    this.step = 0;
    this.nav = 0;
    this.stepCount = "";
    this.checkoutMethod = "API";
    this.direction = "forward";
    this.complete = true;

    this.loadItems();
    this.loadSettings();

    var self = this;
    $(window).unload(function () {
        if (self.clearCart) {self.clearItems();}
//        self.saveItems();
        self.clearCart = false;
    });
}


shoppingCart.prototype.loadSettings = function () {
    var savedSettings = localStorage != null ? localStorage[this.cartName + "_settings"] : null;
    if (savedSettings != null && JSON != null) {
        try {
            var savedSettings = JSON.parse(savedSettings);
            this.checkoutMethod = savedSettings.checkoutType;
        }
        catch (err) {
            // swallow these
        }
    }
};


shoppingCart.prototype.loadItems = function () {
    var items = localStorage != null ? localStorage[this.cartName + "_items"] : null;
    if (items != null && JSON != null) {
        try {
            var items = JSON.parse(items);
            for (var i = 0; i < items.length; i++) {
                var item = items[i];
                if (item.id != null && item.name != null && item.price != null && item.quantity != null) {
                    item = new cartItem(item.id, item.name, item.price, item.quantity);
                    this.items.push(item);
                }
            }
        }
        catch (err) {console.log(err);}
    }
};


shoppingCart.prototype.saveItems = function () {
    if (localStorage != null && JSON != null) {
        localStorage[this.cartName + "_items"] = JSON.stringify(this.items);
    }
};


shoppingCart.prototype.convertItemCurrency = function (currency) {
    for (var i = 0; i < this.items.length; i++) {
        this.items[i].price = money.convert(this.items[i].basePrice, {from: "USD", to: currency});
    }
};


shoppingCart.prototype.deleteProduct = function () {
    if (this.items.length < 1) {
        this.nav = 0;
        this.step = 0;
        toggleCart('product');
    } else {
        toggleCart('cart');
        this.setStep(1);
    }
};

shoppingCart.prototype.addItem = function (id, name, price, basePrice, quantity, recurrence, duration, startup) {
    var scope = "cart";
    quantity = this.toNumber(quantity);
    if (quantity != 0) {
        var found = false;
        for (var i = 0; i < this.items.length && !found; i++) {
            var item = this.items[i];
            if (item.id == id) {
                found = true;
                item.quantity = this.toNumber(item.quantity + quantity);
                if (item.quantity <= 0) {
                    this.items.splice(i, 1);
                    this.deleteProduct();
                } else {
                    this.setStep(1);
                    toggleCart(scope);
                }
            }
        }
        if (!found) {
            var item = new cartItem(id, name, price, basePrice, quantity, recurrence, duration, startup);
            this.items.push(item);
            this.setStep(1);
            setTimeout(function() {toggleCart(scope);}, 300);
        }
    }

};


shoppingCart.prototype.getTotalPrice = function (id) {
    var total = 0;
    for (var i = 0; i < this.items.length; i++) {
        var item = this.items[i];
        if (id == null || item.id == id) {
            total += this.toNumber(item.quantity * item.price);
        }
    }
    return total.toFixed(2);
};


shoppingCart.prototype.getTotalCount = function (id) {
    var count = 0;
    for (var i = 0; i < this.items.length; i++) {
        var item = this.items[i];
        if (id == null || item.id == id) {
            count += this.toNumber(item.quantity);
        }
    }
    return count;
};


shoppingCart.prototype.getGrandTotal = function (id) {
    var grandTotal = Number(this.getTotalPrice()) + Number(this.shippingCost);
    return grandTotal.toFixed(2);
};


shoppingCart.prototype.hasShipping = function () {
    this.stepCount = this.checkoutMethod == 'Inline' ? 4 : 5;
    for (var i = 0; i < this.items.length; i++) {
        var item = this.items[i];
        if (item.id == "PROD") {
            this.stepCount = this.checkoutMethod == 'Inline' ? 4 : 5;
            return true;
        }
    }
    return false;
};


shoppingCart.prototype.setDirection = function (direction) {
    this.step = direction;
};


shoppingCart.prototype.clearItems = function () {
    this.items = [];
};


shoppingCart.prototype.setMethod = function (method) {
    this.checkoutMethod = method;
};

shoppingCart.prototype.getStep = function () {
    return this.step;
};


shoppingCart.prototype.setStep = function (step) {
    this.complete = false;
    this.step = step;
    this.showShipping = this.hasShipping();
    switch (this.step) {
        case 0:
            this.nav = 0;
            toggleCart("product");
            break;
        case 1:
            this.nav = 1;
            location.hash = "#/review";
            break;
        case 2:
            this.step = 2;
            this.nav = 2;
            location.hash = "#/businfo";
            break;
        case 3:
            this.step = 3;
            this.nav = 3;
            location.hash = "#/terms";
            break;
        case 4:
            this.nav = 4;
            this.step = 4;
            location.hash = "#/billing";
            break;
        case 5:
            this.nav = 5;
            this.step = 5;
            location.hash = "#/payment";
            break;
        default:
            break;
    }
    $("html, body").animate({ scrollTop: 0 }, "slow");
};


shoppingCart.prototype.prevStep = function () {
    this.direction = 'back';
    return this.step > 0 ? (this.step - 1) : this.step;
};


shoppingCart.prototype.nextStep = function () {
    return this.step < 5 ? (this.step + 1) : this.step;
};


shoppingCart.prototype.goHome = function () {
    if (window.location.hash !== '#/complete' && window.location.hash !== '#/shop' && window.location.hash !== '') {
       // window.location.reload(true);
    }
};


shoppingCart.prototype.copyShipping = function () {
    this.billing = this.shipping;
};


shoppingCart.prototype.addCheckoutParameters = function (mode, options) {
    this.checkoutParameters[mode] = new checkoutParameters(mode, options);
};


shoppingCart.prototype.mapBilling = function (key) {
    var param = "";
    switch (key) {
    case "name":
        param = "card_holder_name";
        break;
    case "address1":
        param = "street_address";
        break;
    case "address2":
        param = "street_address2";
        break;
    default:
        param = key;
        break;
    }
    return param;
};


shoppingCart.prototype.mapShipping = function (key) {
    var param = "";
    switch (key) {
        case "name":
            param = "ship_name";
            break;
        case "address1":
            param = "ship_street_address";
            break;
        case "address2":
            param = "ship_street_address2";
            break;
        case "city":
            param = "ship_city";
            break;
        case "state":
            param = "ship_state";
            break;
        case "country":
            param = "ship_country";
            break;
        case "zip":
            param = "ship_zip";
            break;
        default:
            param = key;
            break;
    }
    return param;
};


shoppingCart.prototype.checkoutHosted = function (product_id, quantity, lang, currency) {
    document.cookie = 'TCOID =; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    quantity = quantity !== null ? quantity : '1';
    var url = "https://www.2checkout.com/checkout/purchase?sid=202260227";
    url += "&product_id=" + product_id;
    url += "&quantity=" + quantity;
    url += "&lang=" + lang;
    url += "&return_url=https%3A%2F%2Fwww.2checkout.com%2Fdemo";
    
    for (var i in this.billing) {
        if (this.billing[i] !== null) {
           url += "&" + this.mapBilling(i) + "=" + this.billing[i];
        }
    }

    for (var i in this.shipping) {
        if (this.shipping[i] !== null) {
            url += "&" + this.mapShipping(i) + "=" + this.shipping[i];
        }
    }
    
    window.location = url;
};


shoppingCart.prototype.checkoutInline = function (params, clearCart) {
    showSpinner();
    document.cookie = 'TCOID =; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    localStorage.setItem('tcoReferringURL',document.URL);

    var data = {
        sid: "202260227",
        mode: "2CO",
        currency_code: params.currency,
        lang: params.language,
        demo: "Y"
    };

    for (var i in this.billing) {
        if (this.billing[i] !== null) {
            data[this.mapBilling(i)] = this.billing[i];
        }
    }

    if (this.showShipping) {
        for (var i in this.shipping) {
            if (this.shipping[i] !== null) {
                data[this.mapShipping(i)] = this.shipping[i];
            }
        }
    }

    for (var i = 0; i < this.items.length; i++) {
        var item = this.items[i];
        var ctr = i + 1;
        data["li_" + ctr + "_name"] = item.name;
        data["li_" + ctr + "_quantity"] = item.quantity;
        data["li_" + ctr + "_price"] = Number(item.price).toFixed(2);
        if (item.recurrence != "") {
            data["li_" + ctr + "_recurrence"] = item.recurrence;
        }
        if (item.duration != "") {
            data["li_" + ctr + "_duration"] = item.duration;
        }
    }

    if (this.showShipping) {
        ctr = ctr + 1;
        data["li_" + ctr + "_name"] = "Shipping";
        data["li_" + ctr + "_type"] = "Shipping";
        data["li_" + ctr + "_price"] = Number(this.shippingCost).toFixed(2);
    }

    var form = $('<form/></form>');
    form.attr("action", "https://www.2checkout.com/checkout/purchase");
    form.attr("method", "POST");
    form.attr("target", "tco_lightbox_iframe");
    form.attr("style", "display:none;");
    this.addFormFields(form, data);
    $("body").append(form);
    $('.tco_lightbox').remove();

    $.getScript( "https://www.2checkout.com/static/checkout/javascript/direct.min.js", function( data, textStatus, jqxhr ) {
        setTimeout(function() {
            this.clearCart = clearCart == null || clearCart;
            form.submit();
            form.remove();
        }, 1000);
    });

    setTimeout(function() {dismissSpinner();}, 4500);
};


shoppingCart.prototype.checkoutAPI = function (params, clearCart) {
     showSpinner();
     that = this;
     setTimeout(function() {
         that.complete = true;
         that.step = 0;
         that.nav = 0;
         that.clearItems();
         dismissSpinner();
         location.hash = "#/complete";
     }, 5000);
};


shoppingCart.prototype.addFormFields = function (form, data) {
    if (data != null) {
        $.each(data, function (name, value) {
            if (value != null) {
                var input = $("<input></input>").attr("type", "hidden").attr("name", name).val(value);
                form.append(input);
            }
        });
    }
};


shoppingCart.prototype.convertAmount = function (amount, currency) {
    return money.convert(amount, {from: "USD", to: currency});
};


shoppingCart.prototype.toNumber = function (value) {
    value = value * 1;
    return isNaN(value) ? 0 : value;
};

shoppingCart.prototype.resetURL = function () {
};

function checkoutParameters(serviceName, options) {
    this.serviceName = serviceName;
    this.options = options;
}


function cartItem(id, name, price, basePrice, quantity, recurrence, duration, startup) {
    this.id = id;
    this.name = name;
    this.price = price * 1;
    this.basePrice = basePrice * 1;
    this.quantity = quantity * 1;
    this.recurrence = recurrence;
    this.duration = duration;
    this.startup = startup;
}