
const onSave = () =>{
const name = document.querySelector('.Name').value;
const birthdate = document.querySelector('.birthdate').value;
const phone = document.querySelector('.phone').value;
const address = document.querySelector('.address').value;

  const obj = {name, birthdate, phone,address };
  axios.post('/patient', obj)
  .then(response => {console.log(response.data); location.href = '/main/patient.html'})
    .catch(error => {console.log(error);});
}