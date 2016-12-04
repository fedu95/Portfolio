



/* global Thread */

function checkValue(form, message)
{

    var userInput = form[form.id + ":username"];

    if (userInput.value === '')
    {
        alert(message);
        userInput.focus();
        return false;
    }
    return true;
}

function showLetters()
{
    var getBooksCount = ":Filmscount";
    alert(getBooksCount);


}

function borderMenu(value)
{   
    var kalue = document.getElementById(value);
    kalue.style.id = "lol";
    Thread.sleep(1000);
}

