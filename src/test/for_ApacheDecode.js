/**
 * put to Apache24/htdocs/for_ApacheDecode.js
 */


function getUrlQuery(){
    var queryStr = window.location.search.substring(1);
    var queryArray = [];

    if (queryStr){
        var division = queryStr.split('&');

        for (i = 0; i < division.length; i++){
            var reDivision = division[i].split('=');
            queryArray[reDivision[0]] = reDivision[1];
        }//for i

    } else if (!queryStr) {
        queryArray['name'] = "";
        queryArray['pass'] = "";
        queryArray['mail'] = "";
    }//if

    return queryArray;

}//function getUrlQuery()


function decodeName(nameCode){

    var massageDecode = unescape(code);

    return messageDecode;

}//function decode()

