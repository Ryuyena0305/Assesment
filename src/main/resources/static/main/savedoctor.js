
const onSave = () =>{
const name = document.querySelector('.doctorName').value;
const specialty= document.querySelector('.specialty').value;
const phone = document.querySelector('.phone').value;

  const obj = {name, specialty, phone };
  axios.post('/doctor', obj)
  .then(response => {console.log(response.data); location.href = '/main/doctor.html'})
    .catch(error => {console.log(error);});
}