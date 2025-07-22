const quotes = [" \"I didn’t ask how big the room is; I said I cast fireball\"",
"\"But sir, that’s my emotional support knife collection\"",
"\"Go for The eyes Boo !\""]

const html = document.querySelector("html");
const description = document.getElementById("description");
const switchMode = document.getElementById("switchMode");
const changeDesc = document.getElementById("changeDesc");
const pseudoInput = document.getElementById("pseudo");
const alertPseudo = document.getElementById("alertPseudo");
const nextBtn = document.getElementById("next");
const portrayals = document.querySelectorAll(".portrayal");
const content = document.querySelector(".content");
const cardId = document.getElementById("cardId");
const cardName = document.getElementById("cardName");
const cardAvatar = document.getElementById("cardAvatar");
const cardDesc = document.getElementById("cardDesc");

const genres = document.querySelectorAll(".choose_genre");

const moon = document.querySelector(".moon");

let randIndex;


function fadeOut(el) {
    el.style.opacity = 1;
    (function fade() {
        if ((el.style.opacity -= .1) < 0) {
            el.style.display = "none";
        } else {
            requestAnimationFrame(fade);
        }
    })();
};
function fadeIn(el, display) {
    el.style.opacity = 0;
    el.style.display = display || "block";
    (function fade() {
        var val = parseFloat(el.style.opacity);
        if (!((val += .1) > 1)) {
            el.style.opacity = val;
            requestAnimationFrame(fade);
        }
    })();
};

window.addEventListener("load", (e) => {
    randIndex = Math.floor(Math.random() * quotes.length);
    let quoteOnLoad = quotes[randIndex];

    description.value = quoteOnLoad;
});

switchMode.addEventListener("click", (e) =>{
    if (html.dataset.theme == "dark") html.dataset.theme = "light"
    else html.dataset.theme = "dark";
    moon.classList.toggle("sun");
    switchMode.classList.toggle("day");
});

changeDesc.addEventListener("click", (e) =>{
    randIndex == (quotes.length - 1) ? randIndex = 0 : randIndex++;
    description.value = quotes[randIndex];
});

pseudoInput.addEventListener("focusout", (e) => {
    let getValue = pseudoInput.value;

    if (/[a-zA-Z]/g.test(getValue)){
        if (getValue.length >= 3){
            nextBtn.removeAttribute("disabled");
            alertPseudo.textContent = "";
        } else {
            nextBtn.setAttribute("disabled", true);
            alertPseudo.textContent = "Le pseudo doit contenir au moins trois lettre";
        }
    } else {
        nextBtn.setAttribute("disabled", true);
        alertPseudo.textContent = "Le pseudo doit contenir au moins trois lettre";
    }
});


for (let i = 0; i < portrayals.length; i++) {
    let portrayal = portrayals[i];
    portrayal.onclick = function () {
        for (let allPortrayal of portrayals){
            allPortrayal.classList.remove("active");
        }
        this.classList.add("active");
    };
}

nextBtn.addEventListener("click", (e) =>{
    e.preventDefault();

    fadeOut(content);

    setTimeout(
        fadeIn(cardId), 5000
    );
    setTimeout(
        cardId.classList.add("validation"), 5000
    );

    cardName.textContent = pseudoInput.value;
    cardDesc.textContent = description.value;
    cardAvatar.appendChild(document.querySelector(".portrayal.active"))
});

let dataGenre;
for (let i = 0; i < genres.length; i++) {
    let genreLabel = genres[i];
    genreLabel.onclick = function (e) {
        e.stopPropagation();
        dataGenre = this.dataset.genre;
        let portrayalsGenre = document.querySelectorAll(".portrayals")
        for (let portrayal of portrayalsGenre){
            if(portrayal.classList.contains(dataGenre)) {
                portrayal.classList.add("active");
                portrayal.children[0].children[0].classList.add("active")
            }
            else {
                portrayal.classList.remove("active");
                for (let j = 0; j < portrayal.children.length; j++){

                    for (let k = 0; k <  portrayal.children[j].children.length; k++){
                        portrayal.children[j].children[k].classList.remove("active");
                    }

                }
            }
        }
    };
}





