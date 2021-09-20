const toggle = document.getElementById("header-toggle");
const nav = document.getElementById("nav-bar");
const bodypd = document.getElementById("body-pd");
const navlist = document.getElementById("nav_list");

toggle.addEventListener("click", () => {
  // show navbar
  nav.classList.toggle("show");
  // add padding to body
  bodypd.classList.toggle("body-pd");

  navlist.classList.toggle("add_padding");
});

/*===== LINK ACTIVE =====*/
const linkColor = document.querySelectorAll(".nav_link");

function colorLink() {
  if (linkColor) {
    linkColor.forEach((l) => l.classList.remove("active"));
    if (this.id != "header-toggle") {
      this.classList.add("active");
    }
  }
}
linkColor.forEach((l) => l.addEventListener("click", colorLink));
