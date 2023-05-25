moment.tz.setDefault('Asia/Shanghai');
const showToast = (message) => {
    Toastify({
        text: message,
        duration: 2000,
        newWindow: true,
        gravity: "top", // `top` or `bottom`
        position: "center", // `left`, `center` or `right`
        style: {
            background: "#1b5e20",
        },
        offset: {
            y: 40
        }
    }).showToast();
}
const Toast = Swal.mixin({
    toast: true,
    position: 'top-end',
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
})
