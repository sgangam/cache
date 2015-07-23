    var saveForm = function() {

        var form = $('#ajaxform');
        var responseTag = $('#results');
        var doneFunc = function(response) {
                    $(responseTag).removeClass('error');
                    $(responseTag).addClass('success');
                    $(responseTag).text(response);
        }
        var failFunc = function(data) {
            $(responseTag).removeClass('success');
            $(responseTag).addClass('error');

            if (data.responseText !== '') {
                    $(responseTag).text(data.responseText);
            } else {
                    $(responseTag).text('An error occured and the message could not be sent.');
            }
        }
        eventFunc(form, doneFunc, failFunc);

    }

    var queryForm = function() {

        var form = $('#queryform');
        var responseTag = $('#queryresults');
        var doneFunc = function(response) {
                    $(responseTag).removeClass('error');
                    $(responseTag).addClass('success');
                    $(responseTag).text(response);
        }
        var failFunc = function(data) {
            $(responseTag).removeClass('success');
            $(responseTag).addClass('error');

            if (data.responseText !== '') {
                    $(responseTag).text(data.responseText);
            } else {
                    $(responseTag).text('An error occured and the message could not be sent.');
            }
        }
        eventFunc(form, doneFunc, failFunc);

    }

    var ajaxFunction = function() {
        saveForm();
        queryForm();
    }


$(ajaxFunction);

