const doctorid = new URL(location.href).searchParams.get('doctorid');
const onfind = async (doctorid) =>{
    try{

        const response = await axios.get(`/doctor/view?doctorid=${doctorid}`)
        document.querySelector('.doctorName').value = response.data.name
        document.querySelector('.specialty').value = response.data.specialty
        document.querySelector('.phone').value = response.data.phone

    }catch(e){console.log(e)}
}
onfind(doctorid);

const onfindbydoctor = async (doctorid)=>{
try{
const response = await axios.get(`/resv/doctorbyview?doctorid=${doctorid}`)
console.log(response)
    const List = document.querySelector('#reservationList')
    let html='';
    response.data.forEach(resv =>{
        html += `
        <li>환자이름 : ${resv.patientid} 날짜 : ${resv.appointmentdate} 시간 : ${resv.appointmenttime}</li>

            `
    })
    List.innerHTML = html
    }catch(e){console.log(e)}
}
onfindbydoctor(doctorid);


const onUpdate = async () =>{
    const name = document.querySelector('.doctorName').value
    const specialty = document.querySelector('.specialty').value
    const phone = document.querySelector('.phone').value

   const obj = {doctorid, name, specialty, phone}
    const response = await axios.put('/doctor', obj)
    if(response.data ==1){
        alert('변경 성공');
    onfind(doctorid); onfindbydoctor(doctorid);}
}

