const input = document.querySelector("#imagem");
const img = document.querySelector(".imgFile");
const dropbox = document.querySelector(".dropbox");

input.addEventListener("change", () => {
	if(input.files.length) {
		changeImage(input.files[0]);
	}
});

function dragenter(e) {
	e.stopPropagation();
	e.preventDefault();
	console.log("dropenter");
	dropbox.classList.add("drop");
}

function dragover(e) {
	e.stopPropagation();
	e.preventDefault();
	dropbox.classList.add("drop");
}

function dragleave(e) {
	e.stopPropagation();
	e.preventDefault();
	console.log("dropleave");
	dropbox.classList.remove("drop");
}

function dragend(e) {
	e.stopPropagation();
	e.preventDefault();
	console.log("dropleave");
	dropbox.classList.remove("drop");
}

function drop(e) {
	e.stopPropagation();
	e.preventDefault();
	
	console.log("drop");
	console.log(e);
	
	let dt = e.dataTransfer;
	
	console.log(dt);
	console.log(dt.files);
	console.log(dt.files.length);
	
	if (dt.files.length) {
		input.files = dt.files;	
		changeImage(dt.files[0]);
	}
	
	dropbox.classList.remove("drop");
}

function changeImage(file) {
	
	if (file.type.startsWith("image/")) {
		console.log(img);
		//img.src = window.URL.createObjectURL(file);
		const reader = new FileReader();
		console.log(reader);
		reader.readAsDataURL(file);
		reader.onload = () => { img.src = reader.result; };
	}
}


document.addEventListener("dragenter", dragenter);
dropbox.addEventListener("dragover", dragover);
dropbox.addEventListener("dragleave", dragleave);
dropbox.addEventListener("dragend", dragend);
dropbox.addEventListener("drop", drop);