function product(id, name, description, price, recurrence, duration, startupFee) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.basePrice = price;
    this.price = price;
    this.recurrence = recurrence;
    this.duration = duration;
    this.startup = startupFee;
}


function shop() {
    this.products = [
        new product("PROD", "ACME Product", "One Time Tangible", 14.79, null, null, null),
        new product("SUBS", "ACME Subscription", "Recurring Intangible", 9.99, "1 Month", "Forever", 7.50)
    ];
}


shop.prototype.convertCurrency = function (currency) {
    for (var i = 0; i < this.products.length; i++) {
        this.products[i].price = money.convert(this.products[i].basePrice, {from: "USD", to: currency});
    }
};