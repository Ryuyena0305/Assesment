const onfindbydate = async (date)=>{
try{
const response = await axios.get(`/resv/datebyview?appointmentdate=${date}`)
console.log(response)
    const List = document.querySelector('#reservationList')
    let html='';
    response.data.forEach(resv =>{
        html += `
        <li>환자번호 : ${resv.patientid} 예약 시간 : ${resv.appointmenttime}<button "onclick=onUpdateState(resv)">예약상태변경</button></li>

            `
    })
    List.innerHTML = html
    }catch(e){console.log(e)}
}

const onList = () =>{
const sdate = document.querySelector('.sdate').value;
onfindbydate(sdate);

}

const onSavepage = async () =>{
  const List = document.querySelector('.reservationsave')
    let html=`
    <h4>예약 하기</h4>

          <div id="reservationinput">
            <input type="text" class=" patientid" placeholder="환자번호">
            <input type="text" class="doctorid" placeholder="의사번호" >
            <input type="date" class="appointmentdate" placeholder="예약일">
            <input type="time" class="appointmenttime" placeholder="예약시간" >
          </div>

    `;

    List.innerHTML = html
}

const onSave = () =>{
const patientid = document.querySelector('.patientid').value;
const doctorid = document.querySelector('.doctorid').value;
const appointmentdate = document.querySelector('.appointmentdate').value;
const appointmenttime = document.querySelector('.appointmenttime').value;

  const obj = {patientid, doctorid, appointmentdate, appointmenttime };
  axios.post('/resv', obj)
  .then(response => {console.log(response.data); alert('예약 성공')})
    .catch(error => {console.log(error);});
}

const onUpdateState = async (state) =>{
    if(stage==1){
    const response = await axios.put(`/resv/state/${state}`)
    if(response.data ==1){
    alert('변경 성공')
    onfind(patientid); onfindbypatient(patientid);}}
}

const onUpdate = async () =>{


   const obj = {patientid,name, birthdate, phone, address}
    const response = await axios.put('/patient', obj)
    if(response.data ==1){
    alert('변경 성공')
    onfind(patientid); onfindbypatient(patientid);}
}


