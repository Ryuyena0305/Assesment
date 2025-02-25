const patientid = new URL(location.href).searchParams.get('patientid');
console.log(patientid)
const onfind = async (patientid) =>{
    try{

        const response = await axios.get(`/patient/view?patientid=${patientid}`)
        document.querySelector('.patientName').value = response.data.name
        document.querySelector('.birthDate').value = response.data.birthdate
        document.querySelector('.phone').value = response.data.phone
        document.querySelector('.address').value = response.data.address
    }catch(e){console.log(e)}
}
onfind(patientid);

const onfindbypatient = async (patientid)=>{
try{
const response = await axios.get(`/resv/patientbyview?patientid=${patientid}`)
console.log(response)
    const List = document.querySelector('#reservationList')
    let html='';
    response.data.forEach(resv =>{
        html += `
        <li>의사이름 : ${resv.doctorid} 날짜 : ${resv.appointmentdate} 시간 : ${resv.appointmenttime}</li>

            `
    })
    List.innerHTML = html
    }catch(e){console.log(e)}
}
onfindbypatient(patientid);


const onUpdate = async () =>{
    const name = document.querySelector('.patientName').value
    const birthdate = document.querySelector('.birthDate').value
    const phone = document.querySelector('.phone').value
    const address = document.querySelector('.address').value

   const obj = {patientid,name, birthdate, phone, address}
    const response = await axios.put('/patient', obj)
    if(response.data ==1){
    alert('변경 성공')
    onfind(patientid); onfindbypatient(patientid);}
}

