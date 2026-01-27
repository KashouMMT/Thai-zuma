document.addEventListener("DOMContentLoaded", initUI);

function initUI() {
    initOffcanvasMenu();
    //initFloatingActions();
	initEventGallery();
}

/* =============================
   Event Gallery (Swipe + Auto)
============================= */
function initEventGallery() {
	const gallery = document.querySelector('.event-gallery');
	const track = document.querySelector('.event-track');
	const slides = document.querySelectorAll('.event-slide');
	const dots = document.querySelectorAll('.event-dots .dot');

	if (!gallery || !track || slides.length === 0 || dots.length === 0) return;

	let index = 0;
	let startX = 0;
	let currentTranslate = 0;
	let prevTranslate = 0;
	let isDragging = false;
	let autoTimer = null;

	const slideCount = slides.length;
	const interval = 4000; // autoplay interval (ms)
	const thresholdRatio = 0.25;

	/* ---------- Core ---------- */

	function updateSlider(animated = true) {
		track.style.transition = animated ? 'transform 0.4s ease' : 'none';
		track.style.transform = `translateX(-${index * 100}%)`;

		dots.forEach(d => d.classList.remove('active'));
		dots[index].classList.add('active');
	}

	function nextSlide() {
		index = (index + 1) % slideCount;
		updateSlider();
	}

	function startAutoPlay() {
		stopAutoPlay();
		autoTimer = setInterval(nextSlide, interval);
	}

	function stopAutoPlay() {
		if (autoTimer) clearInterval(autoTimer);
	}

	/* ---------- Dots ---------- */

	dots.forEach(dot => {
		dot.addEventListener('click', () => {
			index = Number(dot.dataset.index);
			updateSlider();
			startAutoPlay();
		});
	});

	/* ---------- Swipe / Drag ---------- */

	function onPointerDown(e) {
		stopAutoPlay();
		isDragging = true;
		startX = e.clientX;
		prevTranslate = -index * gallery.offsetWidth;
		track.style.transition = 'none';
	}

	function onPointerMove(e) {
		if (!isDragging) return;
		const diff = e.clientX - startX;
		currentTranslate = prevTranslate + diff;
		track.style.transform = `translateX(${currentTranslate}px)`;
	}

	function onPointerUp() {
		if (!isDragging) return;
		isDragging = false;

		const movedBy = currentTranslate - prevTranslate;
		const threshold = gallery.offsetWidth * thresholdRatio;

		if (movedBy < -threshold && index < slideCount - 1) index++;
		else if (movedBy > threshold && index > 0) index--;

		updateSlider();
		startAutoPlay();
	}

	gallery.addEventListener('pointerdown', onPointerDown);
	window.addEventListener('pointermove', onPointerMove);
	window.addEventListener('pointerup', onPointerUp);
	gallery.addEventListener('pointerleave', onPointerUp);

	/* ---------- Init ---------- */

	updateSlider(false);
	startAutoPlay();
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
----------------------------- 
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
*/