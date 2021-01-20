(function () {
  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["styles"], {
    /***/
    "+EN/":
    /*!*************************!*\
      !*** ./src/styles.scss ***!
      \*************************/

    /*! no static exports found */

    /***/
    function EN(module, exports, __webpack_require__) {
      var api = __webpack_require__(
      /*! ../node_modules/style-loader/dist/runtime/injectStylesIntoStyleTag.js */
      "LboF");

      var content = __webpack_require__(
      /*! !../node_modules/css-loader/dist/cjs.js??ref--13-1!../node_modules/postcss-loader/src??embedded!../node_modules/resolve-url-loader??ref--13-3!../node_modules/sass-loader/dist/cjs.js??ref--13-4!./styles.scss */
      "/I9Y");

      content = content.__esModule ? content["default"] : content;

      if (typeof content === 'string') {
        content = [[module.i, content, '']];
      }

      var options = {};
      options.insert = "head";
      options.singleton = false;
      var update = api(content, options);
      module.exports = content.locals || {};
      /***/
    },

    /***/
    "/I9Y":
    /*!*********************************************************************************************************************************************************************************************************************!*\
      !*** ./node_modules/css-loader/dist/cjs.js??ref--13-1!./node_modules/postcss-loader/src??embedded!./node_modules/resolve-url-loader??ref--13-3!./node_modules/sass-loader/dist/cjs.js??ref--13-4!./src/styles.scss ***!
      \*********************************************************************************************************************************************************************************************************************/

    /*! exports provided: default */

    /***/
    function I9Y(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony import */


      var _node_modules_css_loader_dist_runtime_api_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! ../node_modules/css-loader/dist/runtime/api.js */
      "JPst");
      /* harmony import */


      var _node_modules_css_loader_dist_runtime_api_js__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(_node_modules_css_loader_dist_runtime_api_js__WEBPACK_IMPORTED_MODULE_0__); // Imports


      var ___CSS_LOADER_EXPORT___ = _node_modules_css_loader_dist_runtime_api_js__WEBPACK_IMPORTED_MODULE_0___default()(true); // Module


      ___CSS_LOADER_EXPORT___.push([module.i, "/* You can add global styles to this file, and also import other style files */\nbody {\n  font: 20px/1.5 Arial, Helvetica, sans-serif;\n  padding: 0;\n  margin: 0;\n  background-color: #ffffff;\n}\n/* Global */\n.container {\n  width: 80%;\n  margin: auto;\n  overflow: hidden;\n}\nul {\n  margin: 0;\n  padding: 0;\n}\n.button_1 {\n  height: 50px;\n  position: absolute;\n  background: #28cf48;\n  border-radius: 30px;\n  /* color:#; */\n  text-align: center;\n  width: 180px;\n  border: 3px solid #009688;\n  transform: translate(-50%, -50%);\n  line-height: 60px;\n  font-size: 24px;\n  text-decoration: none;\n  box-sizing: border-box;\n  background: linear-gradient(90deg, #02f471, #f4d241, #3b7dff, #02f413);\n  background-size: 400%;\n}\n/* Header **/\nheader {\n  background: #074f7a;\n  color: #ffffff;\n  padding-top: 30px;\n  min-height: 90px;\n  border-bottom: #28cf48 3px solid;\n}\nheader a {\n  color: #ffffff;\n  text-decoration: none;\n  text-transform: uppercase;\n  font-size: 16px;\n}\nheader li {\n  float: left;\n  display: inline;\n  padding: 0 20px 0 20px;\n}\nheader #branding {\n  float: left;\n}\nheader #branding h1 {\n  margin: 0;\n}\nheader nav {\n  float: right;\n  margin-top: 10px;\n}\nheader .highlight, header .current a {\n  color: #28cf48;\n  font-weight: bold;\n}\nheader a:hover {\n  color: #28cf48;\n  font-weight: bold;\n}\n#branding img {\n  float: right;\n  float: left;\n  width: 70px;\n  height: 100px;\n}\n.dark {\n  padding: 15px;\n  background: #074f7a;\n  color: #ffffff;\n  margin-top: 10px;\n  margin-bottom: 10px;\n}\n.logout-form button {\n  float: right;\n  padding: 5px;\n  border: none;\n  border-radius: 5px;\n  background: #28cf48;\n  font-size: 15px;\n  color: #fff;\n  cursor: pointer;\n}\n.logout-form button:hover {\n  background-color: #074f7a;\n  color: #fff;\n}\n/* Showcase */\n#showcase {\n  position: relative;\n  min-height: 400px;\n  background: url('showcase.jpg') no-repeat;\n  text-align: center;\n  color: #28cf48;\n  background-size: 100% 150%;\n}\n.showcase-overlay {\n  background: rgba(0, 0, 0, 0.35);\n  position: absolute;\n  width: 100%;\n  height: 100%;\n  top: 0;\n  left: 0;\n}\n.tax {\n  position: absolute;\n  text-align: center;\n  top: 50%;\n  left: 50%;\n  opacity: 1;\n  transform: translate(-50%, -50%);\n  width: 100%;\n}\n#showcase span {\n  display: block;\n  margin-top: -80px;\n  z-index: 1;\n}\n.text {\n  color: #00ff31;\n  font-size: 60px;\n  font-weight: 600;\n  letter-spacing: 8px;\n  position: relative;\n  -webkit-animation: text 3s 1;\n          animation: text 3s 1;\n}\n@-webkit-keyframes text {\n  0% {\n    color: #0692e6;\n    margin-bottom: -40px;\n  }\n  30% {\n    letter-spacing: 25px;\n    margin-bottom: -40px;\n  }\n  85% {\n    letter-spacing: 8px;\n    margin-bottom: -40px;\n  }\n}\n@keyframes text {\n  0% {\n    color: #0692e6;\n    margin-bottom: -40px;\n  }\n  30% {\n    letter-spacing: 25px;\n    margin-bottom: -40px;\n  }\n  85% {\n    letter-spacing: 8px;\n    margin-bottom: -40px;\n  }\n}\n#showcase p {\n  font-size: 20px;\n  color: #ffffff;\n  opacity: 4;\n  position: relative;\n  margin-top: 300px;\n}\n#showcase .wrapper {\n  float: left;\n  margin-bottom: 10px;\n  position: absolute;\n}\n#showcase h3 {\n  font-size: 30px;\n  color: #ffffff;\n  font-weight: bold;\n  -webkit-animation: blink 1s infinite;\n          animation: blink 1s infinite;\n  top: 50%;\n  left: 50%;\n}\n#showcase .blink1 {\n  color: #00ff31;\n  margin: 0;\n  float: left;\n}\n@-webkit-keyframes blink {\n  0% {\n    opacity: 1;\n  }\n  50% {\n    opacity: 0;\n  }\n  100% {\n    opacity: 1;\n  }\n}\n@keyframes blink {\n  0% {\n    opacity: 1;\n  }\n  50% {\n    opacity: 0;\n  }\n  100% {\n    opacity: 1;\n  }\n}\n#showcase .wrapper1 {\n  margin-top: -40px;\n  position: absolute;\n  top: 15%;\n  right: 15%;\n}\n#showcase h3 {\n  min-height: 70px;\n  font-size: 30px;\n  color: #ffffff;\n  font-weight: bold;\n  -webkit-animation: blink 1s infinite;\n          animation: blink 1s infinite;\n}\n#showcase .blink2 {\n  color: #00ff31;\n  margin: 0;\n  float: left;\n}\n@keyframes blink {\n  0% {\n    opacity: 1;\n  }\n  50% {\n    opacity: 0;\n  }\n  100% {\n    opacity: 1;\n  }\n}\n/*Join */\n#Join {\n  padding: 15px;\n  color: #ffffff;\n  background: #074f7a;\n}\n#Join h1 {\n  float: left;\n  margin-top: 10px;\n}\n#Join form {\n  float: right;\n  margin-top: 15px;\n}\n#Join input[type=button_1] {\n  height: 25px;\n  width: 250px;\n}\n/* Boxes */\n#boxes {\n  margin-top: 20px;\n}\n#boxes .box {\n  float: left;\n  text-align: center;\n  width: 30%;\n  padding: 10px;\n}\n#boxes .box img {\n  width: 90px;\n}\n/* Sidebar */\naside#sidebar {\n  float: right;\n  width: 30%;\n  margin-top: 10px;\n}\n/* Main-col */\narticle#main-col {\n  text-align: left;\n  float: left;\n  width: 65%;\n}\n/* Services */\nul#services li {\n  list-style: none;\n  padding: 20px;\n  border: #cccccc solid 1px;\n  margin-bottom: 5px;\n  background: #e6e6e6;\n}\ntable {\n  border-collapse: collapse;\n  float: left;\n  width: 30%;\n}\ntable th {\n  text-align: left;\n  background-color: #074f7a;\n  color: #fff;\n  padding: 30px -250px 30px -250px;\n}\ntable td {\n  border: 1px solid #e3e3e3;\n  padding: 8px -10px;\n}\np6 {\n  color: #f51111;\n}\nfooter {\n  padding: 20px;\n  margin-top: 20px;\n  color: #ffffff;\n  background-color: #28cf48;\n  text-align: center;\n}\n/* Smartphones (landscape) ----------- */\n@media only screen and (min-width: 321px) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/*Smartphones (portrait and landscape) ----------- */\n@media only screen and (min-width: 320px) and (max-width: 480px) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* Smartphones (portrait) ----------- */\n@media only screen and (max-width: 320px) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* iPads (portrait and landscape) ----------- */\n@media only screen and (min-width: 768px) and (max-width: 1024px) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* iPads (landscape) ----------- */\n@media only screen and (min-width: 768px) and (max-width: 1024px) and (orientation: landscape) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* iPads (portrait) ----------- */\n@media only screen and (min-width: 768px) and (max-width: 1024px) and (orientation: portrait) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/**********iPad 3\n**********/\n@media only screen and (min-width: 768px) and (max-width: 1024px) and (orientation: landscape) and (-webkit-min-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n@media only screen and (min-width: 768px) and (max-width: 1024px) and (orientation: portrait) and (-webkit-min-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* Desktops and laptops ----------- */\n@media only screen and (min-width: 1224px) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* Large screens ----------- */\n@media only screen and (min-width: 1824px) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* iPhone 4 ----------- */\n@media only screen and (min-width: 320px) and (max-width: 480px) and (orientation: landscape) and (-webkit-min-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n@media only screen and (min-width: 320px) and (max-width: 480px) and (orientation: portrait) and (-webkit-min-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* iPhone 5 ----------- */\n@media only screen and (min-width: 320px) and (max-height: 568px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join form,\n#Join h3,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n@media only screen and (min-width: 320px) and (max-height: 568px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* iPhone 6, 7, 8 ----------- */\n@media only screen and (min-width: 375px) and (max-height: 667px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n@media only screen and (min-width: 375px) and (max-height: 667px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* iPhone 6+, 7+, 8+ ----------- */\n@media only screen and (min-width: 414px) and (max-height: 736px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n@media only screen and (min-width: 414px) and (max-height: 736px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* iPhone X ----------- */\n@media only screen and (min-width: 375px) and (max-height: 812px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n@media only screen and (min-width: 375px) and (max-height: 812px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* iPhone XS Max, XR ----------- */\n@media only screen and (min-width: 414px) and (max-height: 896px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n@media only screen and (min-width: 414px) and (max-height: 896px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h3,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* Samsung Galaxy S3 ----------- */\n@media only screen and (min-width: 320px) and (max-height: 640px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n@media only screen and (min-width: 320px) and (max-height: 640px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* Samsung Galaxy S4 ----------- */\n@media only screen and (min-width: 320px) and (max-height: 640px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n@media only screen and (min-width: 320px) and (max-height: 640px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n/* Samsung Galaxy S5 ----------- */\n@media only screen and (min-width: 360px) and (max-height: 640px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n@media only screen and (min-width: 360px) and (max-height: 640px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\nheader nav,\nheader nav li,\n#Join h1,\n#Join form,\n#boxes .box,\narticle#main-col,\naside#sidebar,\ntable,\ntable th,\ntable td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\nheader {\n  padding-bottom: 20px;\n}\n#Join .button_1 {\n  display: block;\n  width: 120px;\n}", "", {
        "version": 3,
        "sources": ["webpack://src/styles.scss"],
        "names": [],
        "mappings": "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",
        "sourcesContent": ["/* You can add global styles to this file, and also import other style files */\nbody {\n  font: 20px/1.5 Arial, Helvetica, sans-serif;\n  padding: 0;\n  margin: 0;\n  background-color: #ffffff;\n}\n\n/* Global */\n.container {\n  width: 80%;\n  margin: auto;\n  overflow: hidden;\n}\n\nul {\n  margin: 0;\n  padding: 0;\n}\n\n.button_1 {\n  height: 50px;\n  position: absolute;\n  background: #28cf48;\n  border-radius: 30px;\n  /* color:#; */\n  text-align: center;\n  width: 180px;\n  border: 3px solid #009688;\n  transform: translate(-50%, -50%);\n  line-height: 60px;\n  font-size: 24px;\n  text-decoration: none;\n  box-sizing: border-box;\n  background: linear-gradient(90deg, #02f471, #f4d241, #3b7dff, #02f413);\n  background-size: 400%;\n}\n\n\n/* Header **/\nheader {\n  background: #074f7a;\n  color: #ffffff;\n  padding-top: 30px;\n  min-height: 90px;\n  border-bottom: #28cf48 3px solid;\n}\n\nheader a {\n  color: #ffffff;\n  text-decoration: none;\n  text-transform: uppercase;\n  font-size: 16px;\n}\n\n\nheader li {\n  float: left;\n  display: inline;\n  padding: 0 20px 0 20px;\n}\n\nheader #branding {\n  float: left;\n}\n\nheader #branding h1 {\n  margin: 0;\n\n}\n\nheader nav {\n  float: right;\n  margin-top: 10px;\n\n}\n\nheader .highlight, header .current a {\n  color: #28cf48;\n  font-weight: bold;\n}\n\nheader a:hover {\n  color: #28cf48;\n  font-weight: bold;\n}\n\n#branding img {\n  float: right;\n  float: left;\n  width: 70px;\n  height: 100px;\n}\n\n.dark {\n  padding: 15px;\n  background: #074f7a;\n  color: #ffffff;\n  margin-top: 10px;\n  margin-bottom: 10px;\n}\n\n.logout-form button {\n  float: right;\n  padding: 5px;\n  border: none;\n  border-radius: 5px;\n  background: #28cf48;\n  font-size: 15px;\n  color: #fff;\n  cursor: pointer;\n}\n\n.logout-form button:hover {\n  background-color: #074f7a;\n  color: #fff;\n}\n\n/* Showcase */\n#showcase {\n  position: relative;\n  min-height: 400px;\n  background: url('./assets/shared/img/showcase.jpg') no-repeat;\n  text-align: center;\n  color: #28cf48;\n  background-size: 100% 150%;\n}\n\n.showcase-overlay {\n  background: rgba(0, 0, 0, 0.35);\n  position: absolute;\n  width: 100%;\n  height: 100%;\n  top: 0;\n  left: 0;\n}\n\n.tax {\n  position: absolute;\n  text-align: center;\n  top: 50%;\n  left: 50%;\n  opacity: 1;\n  transform: translate(-50%, -50%);\n  width: 100%;\n\n\n}\n\n#showcase span {\n  display: block;\n  margin-top: -80px;\n  z-index: 1;\n}\n\n.text {\n  color: #00ff31;\n  font-size: 60px;\n  font-weight: 600;\n  letter-spacing: 8px;\n  position: relative;\n  animation: text 3s 1;\n}\n\n@keyframes text {\n  0% {\n    color: #0692e6;\n    margin-bottom: -40px;\n  }\n  30% {\n    letter-spacing: 25px;\n    margin-bottom: -40px;\n  }\n  85% {\n    letter-spacing: 8px;\n    margin-bottom: -40px;\n  }\n}\n\n\n#showcase p {\n  font-size: 20px;\n  color: #ffffff;\n  opacity: 4;\n  position: relative;\n  margin-top: 300px;\n}\n\n#showcase .wrapper {\n  float: left;\n  margin-bottom: 10px;\n  position: absolute;\n}\n\n#showcase h3 {\n  font-size: 30px;\n  color: #ffffff;\n  font-weight: bold;\n  animation: blink 1s infinite;\n  top: 50%;\n  left: 50%;\n}\n\n#showcase .blink1 {\n  color: #00ff31;\n  margin: 0;\n  float: left;\n}\n\n@keyframes blink {\n  0% {\n    opacity: 1.0;\n  }\n  50% {\n    opacity: 0.0;\n  }\n  100% {\n    opacity: 1.0;\n  }\n}\n\n#showcase .wrapper1 {\n  margin-top: -40px;\n  position: absolute;\n  top: 15%;\n  right: 15%;\n}\n\n#showcase h3 {\n  min-height: 70px;\n  font-size: 30px;\n  color: #ffffff;\n  font-weight: bold;\n  animation: blink 1s infinite;\n}\n\n#showcase .blink2 {\n  color: #00ff31;\n  margin: 0;\n  float: left;\n}\n\n@keyframes blink {\n  0% {\n    opacity: 1.0;\n  }\n  50% {\n    opacity: 0.0;\n  }\n  100% {\n    opacity: 1.0;\n  }\n}\n\n\n/*Join */\n#Join {\n  padding: 15px;\n  color: #ffffff;\n  background: #074f7a;\n}\n\n#Join h1 {\n  float: left;\n  margin-top: 10px;\n}\n\n#Join form {\n  float: right;\n  margin-top: 15px;\n}\n\n#Join input[type=\"button_1\"] {\n  height: 25px;\n  width: 250px;\n}\n\n\n/* Boxes */\n#boxes {\n  margin-top: 20px;\n}\n\n#boxes .box {\n  float: left;\n  text-align: center;\n  width: 30%;\n  padding: 10px;\n}\n\n#boxes .box img {\n  width: 90px;\n}\n\n/* Sidebar */\naside#sidebar {\n  float: right;\n  width: 30%;\n  margin-top: 10px;\n}\n\n\n/* Main-col */\narticle#main-col {\n  text-align: left;\n  float: left;\n  width: 65%;\n}\n\n/* Services */\nul#services li {\n  list-style: none;\n  padding: 20px;\n  border: #cccccc solid 1px;\n  margin-bottom: 5px;\n  background: #e6e6e6;\n}\n\ntable {\n  border-collapse: collapse;\n  float: left;\n  width: 30%;\n}\n\ntable th {\n  text-align: left;\n  background-color: #074f7a;\n  color: #fff;\n  padding: 30px -250px 30px -250px;\n\n}\n\ntable td {\n  border: 1px solid #e3e3e3;\n  padding: 8px -10px;\n\n}\n\np6 {\n  color: #f51111;\n}\n\nfooter {\n  padding: 20px;\n  margin-top: 20px;\n  color: #ffffff;\n  background-color: #28cf48;\n  text-align: center;\n}\n\n/* Smartphones (landscape) ----------- */\n@media only screen and (min-width: 321px) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/*Smartphones (portrait and landscape) ----------- */\n@media only screen and(min-width: 320px) and (max-width: 480px) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* Smartphones (portrait) ----------- */\n@media only screen and (max-width: 320px) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* iPads (portrait and landscape) ----------- */\n@media only screen and (min-width: 768px) and (max-width: 1024px) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* iPads (landscape) ----------- */\n@media only screen and (min-width: 768px) and (max-width: 1024px) and (orientation: landscape) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* iPads (portrait) ----------- */\n@media only screen and (min-width: 768px) and (max-width: 1024px) and (orientation: portrait) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/**********iPad 3\n**********/\n@media only screen and (min-width: 768px) and (max-width: 1024px) and (orientation: landscape) and (-webkit-min-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n@media only screen and (min-width: 768px) and (max-width: 1024px) and (orientation: portrait) and (-webkit-min-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* Desktops and laptops ----------- */\n@media only screen and (min-width: 1224px) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* Large screens ----------- */\n@media only screen and (min-width: 1824px) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* iPhone 4 ----------- */\n@media only screen and (min-width: 320px) and (max-width: 480px) and (orientation: landscape) and (-webkit-min-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n@media only screen and (min-width: 320px) and (max-width: 480px) and (orientation: portrait) and (-webkit-min-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* iPhone 5 ----------- */\n@media only screen and (min-width: 320px) and (max-height: 568px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join form,\n  #Join h3,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n@media only screen and (min-width: 320px) and (max-height: 568px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* iPhone 6, 7, 8 ----------- */\n@media only screen and (min-width: 375px) and (max-height: 667px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n@media only screen and (min-width: 375px) and (max-height: 667px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* iPhone 6+, 7+, 8+ ----------- */\n@media only screen and (min-width: 414px) and (max-height: 736px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n@media only screen and (min-width: 414px) and (max-height: 736px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* iPhone X ----------- */\n@media only screen and (min-width: 375px) and (max-height: 812px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n@media only screen and (min-width: 375px) and (max-height: 812px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td\n  p6 {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* iPhone XS Max, XR ----------- */\n@media only screen and (min-width: 414px) and (max-height: 896px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n@media only screen and (min-width: 414px) and (max-height: 896px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h3,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* Samsung Galaxy S3 ----------- */\n@media only screen and (min-width: 320px) and (max-height: 640px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n@media only screen and (min-width: 320px) and (max-height: 640px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 2) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* Samsung Galaxy S4 ----------- */\n@media only screen and (min-width: 320px) and (max-height: 640px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n@media only screen and (min-width: 320px) and (max-height: 640px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n/* Samsung Galaxy S5 ----------- */\n@media only screen and (min-width: 360px) and (max-height: 640px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n@media only screen and (min-width: 360px) and (max-height: 640px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 3) {\n  header #branding,\n  header nav,\n  header nav li,\n  #Join h1,\n  #Join form,\n  #boxes .box,\n  article#main-col,\n  aside#sidebar,\n  table,\n  table th,\n  table td {\n    float: none;\n    text-align: center;\n    width: 100%;\n  }\n}\n\n\nheader {\n  padding-bottom: 20px;\n}\n\n\n#Join .button_1 {\n  display: block;\n  width: 120px;\n}\n"],
        "sourceRoot": ""
      }]); // Exports

      /* harmony default export */


      __webpack_exports__["default"] = ___CSS_LOADER_EXPORT___;
      /***/
    },

    /***/
    3:
    /*!*******************************!*\
      !*** multi ./src/styles.scss ***!
      \*******************************/

    /*! no static exports found */

    /***/
    function _(module, exports, __webpack_require__) {
      module.exports = __webpack_require__(
      /*! /root/Documents/maxbackFrontendAngular/src/styles.scss */
      "+EN/");
      /***/
    },

    /***/
    "JPst":
    /*!*****************************************************!*\
      !*** ./node_modules/css-loader/dist/runtime/api.js ***!
      \*****************************************************/

    /*! no static exports found */

    /***/
    function JPst(module, exports, __webpack_require__) {
      "use strict";
      /*
        MIT License http://www.opensource.org/licenses/mit-license.php
        Author Tobias Koppers @sokra
      */
      // css base code, injected by the css-loader
      // eslint-disable-next-line func-names

      module.exports = function (useSourceMap) {
        var list = []; // return the list of modules as css string

        list.toString = function toString() {
          return this.map(function (item) {
            var content = cssWithMappingToString(item, useSourceMap);

            if (item[2]) {
              return "@media ".concat(item[2], " {").concat(content, "}");
            }

            return content;
          }).join('');
        }; // import a list of modules into the list
        // eslint-disable-next-line func-names


        list.i = function (modules, mediaQuery, dedupe) {
          if (typeof modules === 'string') {
            // eslint-disable-next-line no-param-reassign
            modules = [[null, modules, '']];
          }

          var alreadyImportedModules = {};

          if (dedupe) {
            for (var i = 0; i < this.length; i++) {
              // eslint-disable-next-line prefer-destructuring
              var id = this[i][0];

              if (id != null) {
                alreadyImportedModules[id] = true;
              }
            }
          }

          for (var _i = 0; _i < modules.length; _i++) {
            var item = [].concat(modules[_i]);

            if (dedupe && alreadyImportedModules[item[0]]) {
              // eslint-disable-next-line no-continue
              continue;
            }

            if (mediaQuery) {
              if (!item[2]) {
                item[2] = mediaQuery;
              } else {
                item[2] = "".concat(mediaQuery, " and ").concat(item[2]);
              }
            }

            list.push(item);
          }
        };

        return list;
      };

      function cssWithMappingToString(item, useSourceMap) {
        var content = item[1] || ''; // eslint-disable-next-line prefer-destructuring

        var cssMapping = item[3];

        if (!cssMapping) {
          return content;
        }

        if (useSourceMap && typeof btoa === 'function') {
          var sourceMapping = toComment(cssMapping);
          var sourceURLs = cssMapping.sources.map(function (source) {
            return "/*# sourceURL=".concat(cssMapping.sourceRoot || '').concat(source, " */");
          });
          return [content].concat(sourceURLs).concat([sourceMapping]).join('\n');
        }

        return [content].join('\n');
      } // Adapted from convert-source-map (MIT)


      function toComment(sourceMap) {
        // eslint-disable-next-line no-undef
        var base64 = btoa(unescape(encodeURIComponent(JSON.stringify(sourceMap))));
        var data = "sourceMappingURL=data:application/json;charset=utf-8;base64,".concat(base64);
        return "/*# ".concat(data, " */");
      }
      /***/

    },

    /***/
    "LboF":
    /*!****************************************************************************!*\
      !*** ./node_modules/style-loader/dist/runtime/injectStylesIntoStyleTag.js ***!
      \****************************************************************************/

    /*! no static exports found */

    /***/
    function LboF(module, exports, __webpack_require__) {
      "use strict";

      var isOldIE = function isOldIE() {
        var memo;
        return function memorize() {
          if (typeof memo === 'undefined') {
            // Test for IE <= 9 as proposed by Browserhacks
            // @see http://browserhacks.com/#hack-e71d8692f65334173fee715c222cb805
            // Tests for existence of standard globals is to allow style-loader
            // to operate correctly into non-standard environments
            // @see https://github.com/webpack-contrib/style-loader/issues/177
            memo = Boolean(window && document && document.all && !window.atob);
          }

          return memo;
        };
      }();

      var getTarget = function getTarget() {
        var memo = {};
        return function memorize(target) {
          if (typeof memo[target] === 'undefined') {
            var styleTarget = document.querySelector(target); // Special case to return head of iframe instead of iframe itself

            if (window.HTMLIFrameElement && styleTarget instanceof window.HTMLIFrameElement) {
              try {
                // This will throw an exception if access to iframe is blocked
                // due to cross-origin restrictions
                styleTarget = styleTarget.contentDocument.head;
              } catch (e) {
                // istanbul ignore next
                styleTarget = null;
              }
            }

            memo[target] = styleTarget;
          }

          return memo[target];
        };
      }();

      var stylesInDom = [];

      function getIndexByIdentifier(identifier) {
        var result = -1;

        for (var i = 0; i < stylesInDom.length; i++) {
          if (stylesInDom[i].identifier === identifier) {
            result = i;
            break;
          }
        }

        return result;
      }

      function modulesToDom(list, options) {
        var idCountMap = {};
        var identifiers = [];

        for (var i = 0; i < list.length; i++) {
          var item = list[i];
          var id = options.base ? item[0] + options.base : item[0];
          var count = idCountMap[id] || 0;
          var identifier = "".concat(id, " ").concat(count);
          idCountMap[id] = count + 1;
          var index = getIndexByIdentifier(identifier);
          var obj = {
            css: item[1],
            media: item[2],
            sourceMap: item[3]
          };

          if (index !== -1) {
            stylesInDom[index].references++;
            stylesInDom[index].updater(obj);
          } else {
            stylesInDom.push({
              identifier: identifier,
              updater: addStyle(obj, options),
              references: 1
            });
          }

          identifiers.push(identifier);
        }

        return identifiers;
      }

      function insertStyleElement(options) {
        var style = document.createElement('style');
        var attributes = options.attributes || {};

        if (typeof attributes.nonce === 'undefined') {
          var nonce = true ? __webpack_require__.nc : undefined;

          if (nonce) {
            attributes.nonce = nonce;
          }
        }

        Object.keys(attributes).forEach(function (key) {
          style.setAttribute(key, attributes[key]);
        });

        if (typeof options.insert === 'function') {
          options.insert(style);
        } else {
          var target = getTarget(options.insert || 'head');

          if (!target) {
            throw new Error("Couldn't find a style target. This probably means that the value for the 'insert' parameter is invalid.");
          }

          target.appendChild(style);
        }

        return style;
      }

      function removeStyleElement(style) {
        // istanbul ignore if
        if (style.parentNode === null) {
          return false;
        }

        style.parentNode.removeChild(style);
      }
      /* istanbul ignore next  */


      var replaceText = function replaceText() {
        var textStore = [];
        return function replace(index, replacement) {
          textStore[index] = replacement;
          return textStore.filter(Boolean).join('\n');
        };
      }();

      function applyToSingletonTag(style, index, remove, obj) {
        var css = remove ? '' : obj.media ? "@media ".concat(obj.media, " {").concat(obj.css, "}") : obj.css; // For old IE

        /* istanbul ignore if  */

        if (style.styleSheet) {
          style.styleSheet.cssText = replaceText(index, css);
        } else {
          var cssNode = document.createTextNode(css);
          var childNodes = style.childNodes;

          if (childNodes[index]) {
            style.removeChild(childNodes[index]);
          }

          if (childNodes.length) {
            style.insertBefore(cssNode, childNodes[index]);
          } else {
            style.appendChild(cssNode);
          }
        }
      }

      function applyToTag(style, options, obj) {
        var css = obj.css;
        var media = obj.media;
        var sourceMap = obj.sourceMap;

        if (media) {
          style.setAttribute('media', media);
        } else {
          style.removeAttribute('media');
        }

        if (sourceMap && btoa) {
          css += "\n/*# sourceMappingURL=data:application/json;base64,".concat(btoa(unescape(encodeURIComponent(JSON.stringify(sourceMap)))), " */");
        } // For old IE

        /* istanbul ignore if  */


        if (style.styleSheet) {
          style.styleSheet.cssText = css;
        } else {
          while (style.firstChild) {
            style.removeChild(style.firstChild);
          }

          style.appendChild(document.createTextNode(css));
        }
      }

      var singleton = null;
      var singletonCounter = 0;

      function addStyle(obj, options) {
        var style;
        var update;
        var remove;

        if (options.singleton) {
          var styleIndex = singletonCounter++;
          style = singleton || (singleton = insertStyleElement(options));
          update = applyToSingletonTag.bind(null, style, styleIndex, false);
          remove = applyToSingletonTag.bind(null, style, styleIndex, true);
        } else {
          style = insertStyleElement(options);
          update = applyToTag.bind(null, style, options);

          remove = function remove() {
            removeStyleElement(style);
          };
        }

        update(obj);
        return function updateStyle(newObj) {
          if (newObj) {
            if (newObj.css === obj.css && newObj.media === obj.media && newObj.sourceMap === obj.sourceMap) {
              return;
            }

            update(obj = newObj);
          } else {
            remove();
          }
        };
      }

      module.exports = function (list, options) {
        options = options || {}; // Force single-tag solution on IE6-9, which has a hard limit on the # of <style>
        // tags it will allow on a page

        if (!options.singleton && typeof options.singleton !== 'boolean') {
          options.singleton = isOldIE();
        }

        list = list || [];
        var lastIdentifiers = modulesToDom(list, options);
        return function update(newList) {
          newList = newList || [];

          if (Object.prototype.toString.call(newList) !== '[object Array]') {
            return;
          }

          for (var i = 0; i < lastIdentifiers.length; i++) {
            var identifier = lastIdentifiers[i];
            var index = getIndexByIdentifier(identifier);
            stylesInDom[index].references--;
          }

          var newLastIdentifiers = modulesToDom(newList, options);

          for (var _i = 0; _i < lastIdentifiers.length; _i++) {
            var _identifier = lastIdentifiers[_i];

            var _index = getIndexByIdentifier(_identifier);

            if (stylesInDom[_index].references === 0) {
              stylesInDom[_index].updater();

              stylesInDom.splice(_index, 1);
            }
          }

          lastIdentifiers = newLastIdentifiers;
        };
      };
      /***/

    }
  }, [[3, "runtime"]]]);
})();
//# sourceMappingURL=styles-es5.js.map