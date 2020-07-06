/**
 * put to Apache24/htdocs/for_ApacheDecode.js
 */


function getUrlQuery(){
  var queryStr = window.location.search.substring(2);
  var queryArray = [];

    if (queryStr){
        var division = queryStr.split('%m');

        for (i = 0; i < division.length; i++){
            queryArray[i] = division[i];
        }//for i

    }//if

    return queryArray;

}//function getUrlQuery()


function decode(){
    var queryArray = getUrlQuery();
    var code = "";

    for (i = 0; i < queryArray.length; i++){
        code = "%u" + queryArray[i];
    }
    var mailDecode = unescape(code);

    return mailDecode;

}//function decode()

