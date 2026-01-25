document.addEventListener("DOMContentLoaded", initUI);

function initUI() {
    initOffcanvasMenu();
    initFloatingActions();
	topNavbarBehavior();
	updateGallery();
	nextImage();
	prevImage();
}

let currentIndex = 0;

function updateGallery() {
	const track = document.querySelector('.gallery-track');
	if (!track) return;
	track.style.transform = `translateX(-${currentIndex * 100}%)`;
}

function nextImage() {
	const images = document.querySelectorAll('.gallery-image');
	if (!images.length) return;
	currentIndex = (currentIndex + 1) % images.length;
	updateGallery();
}

function prevImage() {
	const images = document.querySelectorAll('.gallery-image');
	if (!images.length) return;
	currentIndex = (currentIndex - 1 + images.length) % images.length;
	updateGallery();
}

/* -----------------------------
   TopNavbar Behavior
----------------------------- */
function topNavbarBehavior() {
	const topNavbar	= document.getElementById("top-navbar");
	const header = document.getElementById("site-header");
	if(!topNavbar || !header) return;
	
	const observer = new IntersectionObserver(
		([entry]) => {
			if(entry.isIntersecting) {
				topNavbar.classList.remove("fixed-top");
			} else {
				topNavbar.classList.add("fixed-top");
			}
		},{
			threshold: 0
		}
	);
	observer.observe(header);
}

/* -----------------------------
   Offcanvas menu behavior
----------------------------- */
function initOffcanvasMenu() {
    const menuBtn = document.getElementById("menuBtn");
    const offcanvas = document.getElementById("menuOffcanvas");

    if (!menuBtn || !offcanvas) return;

    offcanvas.addEventListener("shown.bs.offcanvas", () => {
        menuBtn.style.opacity = "0";
        menuBtn.style.pointerEvents = "none";
    });

    offcanvas.addEventListener("hidden.bs.offcanvas", () => {
        menuBtn.style.opacity = "1";
        menuBtn.style.pointerEvents = "auto";
    });
}

/* -----------------------------
   Floating action buttons
----------------------------- */
function initFloatingActions() {
    const header = document.querySelector("header");
	const footer = document.querySelector("footer");
    const floating = document.getElementById("floatingActions");

    if (!header || !floating || !footer) return;

    let headerVisible = true;
    let footerVisible = false;

    const observer = new IntersectionObserver(
        (entries) => {
            entries.forEach((entry) => {
                if (entry.target === header) {
                    headerVisible = entry.isIntersecting;
                }

                if (entry.target === footer) {
                    footerVisible = entry.isIntersecting;
                }
            });

            // Show only when BOTH are NOT visible
            floating.classList.toggle(
                "show",
                !headerVisible && !footerVisible
            );
        },
        { threshold: 0 }
    );

    observer.observe(header);
    observer.observe(footer);
}
