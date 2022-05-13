<!DOCTYPE html>
<html>

<head>
    <title>AIS</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<style>
    * {
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }

    html,
    body {
        height: 100%;
        width: 100%;
        background: #fefff9;
        font-family: 'Times New Roman', Times, serif;
        font-size: 16px;
    }

    header {
        height: 150px;
        border-bottom: 3px solid gray;
    }

    .logo {
        height: 120px;
    }

    .subheader-block {
        text-align: center;
        padding: 5px 0;
    }

    .subheader-block h2 {
        font-size: 22px;
        border-bottom: 1px solid black;
        width: 200px;
        text-align: center;
        display: inline-block;
        margin: 5px 0;
    }

    .content-block {
        width: 100%;
        padding: 10px;
        height: 100%;
    }

    .mar_b_30 {
        margin-bottom: 30px;
        display: block;
    }



    .container {
        text-align: center;
        margin-bottom: 10px;
    }

    .line {
        height: 5px;
        background: gray;
    }

    h4 {
        position: relative;
        top: 12px;
        background: #fff;
        display: inline-block;
        padding: 0 20px;
    }



    footer {
        font-family: 'Times New Roman', Times, serif;
    }

    .empty-div {
        height: 100px;
    }

    .empty-row {
        height: 70px;
    }

    .empty-row-50 {
        height: 30px;
    }

    table,
    th,
    td {
        border: 1px solid black;
        border-collapse: collapse;
    }

    th,
    td {
        padding: 5px;
        text-align: center;
    }

    @media print {
        .content-block {
            width: 100%;
            padding: 10px;
        }

        .empty-div {
            height: 20px;
        }
    }

    table.border_none,
    table.border_none th,
    table.border_none td {
        border: none !important;
        text-align: left;
    }
</style>

<body>
    <div class="content-block">
   
       <#-- <div class="subheader-block">
            <h2>OFFER LETTER</h2>
            <h3>PRIVATE & CONFIDENTIAL</h3>
        </div> -->
        <div class="bold-textblock">
            <span class="mar_b_30"><p>Date:  </p>${doc}</span><br/><br/>
            ${salutation} <b> ${fullName}</b><br/>
            ${address}
            <p><b>Subject:</b> Offer Letter with AIS Business Solutions Pvt Ltd.</p>
            </div>
        <div class="letter-body">
            
            <span>Dear ${firstName},</span>
            <br/>
            <p align="justify">With reference to your discussions & interviews with us, we are pleased to offer you the position of <b> ${position} </b> at our
              <b> ${locationName} </b> office on mutually agreed terms & conditions mentioned below. We feel confident that your skills & knowledge will 
              be of a great value to our organisation.</p>
            
            <p align="justify">1. Your compensation shall be ₹ <b> ${ctc} </b> per annum on Total Cost to Company Basis.
            		A break-up of the same is enclosed herewith for your reference as Annexure-1.</p>
            
            <p align="justify">2. This offer is subject to your acceptance of joining us on or before <b> ${doj} </b> failing, 
            		which your offer letter shall be deemed as withdrawn without further notice.</p>
            		
            <p align="justify">3. Your employment in our organization is subject to your successful clearance of Background check, 
           				 Police Verification whichever is applicable for the said position.</p>
            		
            <p align="justify">4. You will be on a probation period for the first <b> ${probation} </b> months. Please note that you will not be eligible for 
            			any paid leaves during your probation period. You will be eligible for USA / Indian holidays as per business requirements</p>
            		
            <p align="justify">5. You will be governed by the general terms and conditions and the rules & regulations as applicable to the employees of 
            the company in the grade.</p>
            		
            <p align="justify">6. If any of the details provided by you during the interview process & thereafter are found incorrect or if any material 
            			information is detected by us to have been suppressed by you or any action on your part is 
		            found to be in contravention to the terms and conditions of employment or the Company’s Code of Conduct, 
		            the company may terminate your appointment /services without any notice.</p>
            		
            <p align="justify">7. You will also be required to sign a detailed letter of appointment containing the terms and condition of your employment, 
            		which will be issued to you on the date of joining.</p>
            
            <p align="justify">Thanking you,</p>
            <p align="justify">Your Sincerely, <br/> For AIS Business Solutions Pvt. Ltd.</p>
           
          <b>${disclaimer}</b>
          <br/>
          <b>${hrText}</b>          
           
            <br/>
           
            <p align="center"><b>ANNEXURE – A</b></P>
            
           <table align="center" style="width:80%;" class="border_none">
           		<tr>
                    <td style="text-align: center;height:35px" colspan="2"> CTC (Cost to Company) </td>
                </tr>            
                <tr>
                    <td> Name </td>
                    <td> ${fullName} </td>
                </tr>
                <tr>
                    <td> Designation </td>
                    <td> ${position} </td>
                </tr>
            </table>
            
                <br/>
                        
            <table align="center" style="width:80%;" class="border_none">
                <tr style="background-color:#D3D3D3;height:35px">
                    <th>Components</th>
                    <th>Per Annum (₹)</th>
                </tr>
                <tr>
                    <td>Basic Pay</td>
                    <td style="text-align: right"> ${basicPay}</td>
                </tr>
                <tr>
                    <td>HRA</td>
                    <td style="text-align: right"> ${hra}</td>
                </tr>
                <tr>
                    <td>Statutory Bonus</td>
                    <td style="text-align: right"> ${statutoryBonus}</td>
                </tr>
                <tr>
                    <td>LTA</td>
                    <td style="text-align: right"> ${lta}</td>
                </tr>
                <tr>
                    <td>Special Allowance</td>
                    <td style="text-align: right"> ${specialAllowance}</td>
                </tr>
                <tr>
                    <td>Gross Salary</td>
                    <td style="text-align: right"> ${grossSalary}</td>
                </tr>
                <tr>
                    <td># PF Employer Contribution</td>
                    <td style="text-align: right"> ${pf}</td>
                </tr>
                  <tr>
                    <td>Annual Base Salary</td>
                    <td style="text-align: right"> ${annualbaseSalary}</td>
                </tr>
                 <tr>
                    <td>Potential Performance Pay % Maximum upto</td>
                    <td style="text-align: right"> ${potentialperfpayPercentage}</td>
                </tr>
                <tr>
                    <td><b>Performance Pay (Round off Figure)</b></td>
                    <td style="text-align: right"> <b>${performancePay}</b></td>
                </tr>
                 <tr>
                    <td><b>Cost to Company</b></td>
                    <td style="text-align: right"> <b>${ctc}</b></td>
                </tr>
            </table>
            
             <p align="justify">Based on your confirmation, your PF Contribution shall be 
                    ${pfcontributionName} 
                </p>
                
              <p align="justify"><b>Note : </b>
              </p>
              
              <p align="justify">• You will also be eligible for Gratuity, 
		              Group Medical Insurance and Personal Accident insurance as per the Company policy 
		              and applicable laws in addition to above mentioned CTC.
              </p>
              
              <p align="justify">• Performance based variable bonus shall be disbursed once a year in the month of April. If an employee joins on or before 30th September, 
              				he/she is eligible for bonus & yearly appraisal in the month of April in the subsequent year on prorate basis. 
              		If an employee joins on or after 01st October, he/she will be eligible for bonus & yearly appraisal in the next to next April.
              </p>
              <br/><br/>
              <br/>
             <br/>
             <br/>
             <br/>
            <br/>
               <p align="justify">Please note that, you are required to submit the below mentioned documents in original for verification and submit the 
               				photocopy of the same on the date of your joining.
              </p>        
            
        </div> 
      
        
        
       <#--FOR DOCUMENT TABLE -->
        <#-- <div class="empty-row-50"></div> -->
          
            <table style="width:100%">
          
           <tr><th colspan="3" style="background-color:Yellow;height:70px">Document Checklist</th></tr>
           
                <tr style="background-color:Yellow;height:40px">
                    <th>Sr. No.</th>
                    <th>Name of Document</th>
                    <th>No. of Copies Required</th>
                </tr>
            
                <tr>
                    <td>1</td>
                    <td style="text-align:left;height:40px">Final Year Mark sheet & Degree Certificate of Graduation/PG</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td style="text-align:left;height:40px">Residential Proof (Latest Electricity Bill or Rent Agreement)</td>
                    <td>1</td>
                </tr>
              
                <tr>
                    <td>3</td>
                    <td style="text-align:left;height:40px">PAN Card</td>
                    <td>2</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td style="text-align:left;height:40px">Aadhar Card</td>
                    <td>2</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td style="text-align:left;height:40px">Copy of Parent's Aadhar Card</td>
                    <td>2</td>
                </tr>
                <tr>
                    <td>6</td>
                    <td style="text-align:left;height:40px">Recent passport size photograph</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>7</td>
                    <td style="text-align:left;height:40px">Relieving letter from Previous Employer/s – Last 07 Years</td>
                    <td>3</td>
                </tr>
                <tr>
                    <td>8</td>
                    <td style="text-align:left;height:40px">Last 03 Month Payslips</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>9</td>
                    <td style="text-align:left;height:40px">Copy of Bank Pass Book or Cancelled Cheque with Name printed
					</td>
                    <td>1</td>
                </tr>
              
            </table>
            <br/>
                        <p style="text-align:center"><b>** End of Document**</b></p>
        <#--FOR DOCUMENT TABLE END-->
    </div>
</body>

</html>