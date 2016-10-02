function settings(settingsObject) {
    this.settingsObj = settingsObject;
    this.clearSettings = false;
    this.language = "en";
    this.currency = "USD";
    this.symbol = "$";
    this.checkoutType = "API";

    this.loadSettings();

    var self = this;
    $(window).unload(function () {
        if (self.clearSettings) {self.resetSettings();}
        self.saveSettings();
        self.clearSettings = false;
    });
}


settings.prototype.loadSettings = function () {
    var savedSettings = localStorage != null ? localStorage[this.settingsObj + "_settings"] : null;
    if (savedSettings != null && JSON != null) {
        try {
            var savedSettings = JSON.parse(savedSettings);
            this.language = savedSettings.language;
            this.currency = savedSettings.currency;
            this.symbol = savedSettings.symbol;
            this.checkoutType = savedSettings.checkoutType;
        }
        catch (err) {
            // swallow these
        }
    }
};


settings.prototype.saveSettings = function () {
    if (localStorage != null && JSON != null) {
        localStorage[this.settingsObj + "_settings"] = JSON.stringify(this);
    }
};


settings.prototype.resetSettings = function () {
    this.language = "en";
    this.currency = "USD";
    this.symbol = "$";
    this.checkoutType = "API";
    this.saveSettings();
};


settings.prototype.setCheckoutType = function (type) {
    this.checkoutType = type;
    if (type == "Hosted") {
        this.currency = "USD";
        this.symbol = "$";
        location.hash = "#/shop";
    } else if (type == "Inline" && location.hash != "#/shop") {
        location.hash = "#/review";
    }
};

settings.prototype.setCurrencySymbol = function () {
   switch (this.currency) {
       case "GBP":
           this.symbol = "£";
           break;
       case "EUR":
           this.symbol = "€";
           break;
       case "AED":
           this.symbol = "د.إ";
           break;
       case "BRL":
           this.symbol = "R$";
           break;
       case "CHF":
           this.symbol = "CHF";
           break;
       case "DKK":
           this.symbol = "kr";
           break;
       case "ILS":
           this.symbol = "₪";
           break;
       case "INR":
           this.symbol = "Rs.";
           break;
       case "JPY":
           this.symbol = "¥";
           break;
       case "LTL":
           this.symbol = "Lt";
           break;
       case "MYR":
           this.symbol = "RM";
           break;
       case "NOK":
           this.symbol = "kr";
           break;
       case "PHP":
           this.symbol = "₱";
           break;
       case "RON":
           this.symbol = "lei";
           break;
       case "RUB":
           this.symbol = "руб";
           break;
       case "SEK":
           this.symbol = "¤";
           break;
       case "TRY":
           this.symbol = "₤";
           break;
       case "ZAR":
           this.symbol = "R";
           break;
       default:
           this.symbol = "$";
   }
};

settings.prototype.bindPayPal = function () {
    $('#help-popup.modal, #paypal-overlay, .paypal-close, #paypal-btn').click(function() {
        $('#paypal-popup.modal, #paypal-overlay').fadeToggle(300);
    });
};