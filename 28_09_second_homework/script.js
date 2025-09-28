let slideIndex = 1;
currentSlide(slideIndex);

function switchTheme(){
    document.body.classList.toggle("dark-mode");
}

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("slides");
  let dots = document.getElementsByClassName("demo");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}

const formCheck = document.getElementById("name");
formCheck.onblur = validateForm();

function validateForm() {
  let x = document.forms["myForm"]["name"].value;
  let alert = document.getElementById("alert");
  if (x == "") {
    alert.innerHTML = "Заполните поле";
    alert.style.backgroundColor = "#FFACAC"
  }
  else {
    alert.innerHTML = "Ок, " + x;
    alert.style.backgroundColor = "#73d583ff";
  }
}
function redirect(link){
    window.location.href = link;
}