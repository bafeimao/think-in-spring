import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.util.Terser;

/**
 * @projectName: think-in-spring
 * @package: PACKAGE_NAME
 * @className: test
 * @author: ycd20
 * @description: TODO
 * @date: 2023/3/2 17:14
 * @version: 1.0
 */
public class test {
    public static void main(String[] args) throws HL7Exception {

        String messageTest = "MSH|^~\\&|LIS|LIS|HIS|HIS|20230228084221||OUL^R21^OUL_R21|B5B4D6F8B55E4643A5F1ED0007D01679|P|2.6|||NE|AL||utf-8\n" + "        PID||6000022567|||拿铁||17950903|1\n" + "        PV1||2|008^10081^50^10082||||||||||||||||1||||||||||||||||||||H0001|||||20230228084221\n" + "        ORC|SN||||||||||||||||||||||||||||C|||血透门诊^^10105\n" + "        OBR|1|01C202302-2800002^^38349|5610417|250101003^血浆-血气分析|||20230225153721|||||||20230228084221|血浆&17|||||||20230228084221|||F|||||||||1371&王然|0383&陈新宽||||||||||||^M1-血球仪BC5390(二楼门诊)\n" + "        OBX|1|NM|0101001^白细胞|71283345|10.73|^10\\S\\9/L|3.5-9.5|↑|||F||||||N\n" + "        OBX|2|NM|0101003^中性细胞比率|71283346|57.6|^%|40.0-75.0||||F||||||N\n" + "        OBX|3|NM|0101005^淋巴细胞百分比|71283347|31.9|^%|20.0-50.0||||F||||||N\n" + "        OBX|4|NM|0101011^嗜酸性粒细胞比率|71283348|0.4|^%|0.4--8||||F||||||N\n" + "        ORC|SN||||||||||||||||||||||||||||C|||血透门诊^^10105";
        String test2 = "MSH|^~\\&|SendingApp|SendingFac|ReceivingApp|ReceivingFac|20120226102502||ORU^R01|Q161522306T164850327|P|2.3\n" + "PID|1||000168674|000168674|GUNN^BEBE||17821201|F||||||||M|||890-12-3456|||N||||||||N\n" + "PV1|1|I||EL|||00976^PHYSICIAN^DAVID^G|976^PHYSICIAN^DAVID^G|01055^PHYSICIAN^RUTH^K~02807^PHYSICIAN^ERIC^LEE~07017^GI^ASSOCIATES~01255^PHYSICIAN^ADAM^I~02084^PHYSICIAN^SAYED~01116^PHYSICIAN^NURUDEEN^A~01434^PHYSICIAN^DONNA^K~02991^PHYSICIAN^NICOLE|MED||||7|||00976^PHYSICIAN^DAVID^G||^^^Chart ID^Vis|||||||||||||||||||||||||20120127204900\n" + "ORC|RE|||||||||||00976^PHYSICIAN^DAVID^G\n" + "OBR|1|88855701^STDOM|88855701|4083023^PT|||20120226095400|||||||20120226101300|Blood|01255||||000002012057000145||20120226102500||LA|F||1^^^20120226040000^^R~^^^^^R|||||||||20120226040000\n" + "OBX|1|NM|PT Patient^PT||22.5|second(s)|11.7-14.9|H|||F|||20120226102500||1^SYSTEM^SYSTEM\n" + "OBX|2|NM|PT (INR)^INR||1.94||||||F|||20120226102500||1^SYSTEM^SYSTEM\n" + "NTE|1||The optimal INR therapeutic range for stable patients on oral anticoagulants is 2.0 - 3.0.  With mechanical heart valves,\n" + "NTE|2||the range is 2.5 - 3.5.\n" + "NTE|3\n" + "NTE|4||Studies published in NEJM show that patients treated long-term with low intensity warfarin therapy for prevention of recurrent\n" + "NTE|5||venous thromboembolism (with a target INR of 1.5 - 2.0) had a superior outcome.  These results were seen in patients after a median\n" + "NTE|6||6 months of full dose anti-coagulation.";
        // instantiate a PipeParser, which handles the "traditional or default encoding"
        PipeParser ourPipeParser = PipeParser.getInstanceWithNoValidation();

        // parse the message string into a Java message object
        Message orderResultsHl7Message = ourPipeParser.parse(messageTest);

        //create a terser object instance by wrapping it around the message object
        Terser terser = new Terser(orderResultsHl7Message);

        //now, let us do various operations on the message
        OurTerserHelper terserDemonstrator = new OurTerserHelper(terser);


//        String patientId = terserDemonstrator.getData("MSH-25-1");
//        System.out.println("patientId " + patientId);
//        String patientName = terserDemonstrator.getData("MSH-28-1");
//        System.out.println("patientName " + patientName);
//        String messageType = terserDemonstrator.getData("/.*MSH-9-1") + terserDemonstrator.getData("/.*MSH-9-2") + terserDemonstrator.getData("/.*MSH-9-3") + terserDemonstrator.getData("/.*MSH-17-1");
//        System.out.println("messageType " + messageType);
//        String eventType = terserDemonstrator.getData("MSH-17");
//        System.out.println("事件类型 " + eventType);
//        String eventTime = terserDemonstrator.getData("MSH-20");
//        System.out.println("事件时间 " + eventTime);
        XMLParser xmlParser = new DefaultXMLParser();

        // convert from default encoded message into XML format, and send it to standard out for display
        System.out.println(xmlParser.encode(orderResultsHl7Message));

        System.out.println(terserDemonstrator.getData("/.MSH-249-1(0)"));

        //152  +17=169  186  203

    }
}
