import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import bin.CarClassTest;


public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date day = new Date();
		GregorianCalendar d = new GregorianCalendar();
		day = d.getTime();
		System.out.println(day.toString());
		System.out.println(d.getTime());
		int today = d.get(Calendar.DAY_OF_MONTH);
		int month = d.get(Calendar.MONTH);
		
		d.set(Calendar.DAY_OF_MONTH, 1);//why
		
		int weekday = d.get(Calendar.DAY_OF_WEEK);
		
		int firstDayOfWeek = d.getFirstDayOfWeek();
		
		int indent = 0;
		while(weekday != firstDayOfWeek){
			indent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM");
		Date tmp = null;
		try {
			 tmp = dd.parse("1999-12");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ans = dd.format(tmp);
		System.out.println(tmp.toString()+"*********"+ans);
		String sss = "name`,`activity`,`useCount`,`description`,`tags`,`organization`,`projectLinks`,`codeLocation`,`licenses`,`similarProjects`,`managers`,`commitNum`,`contributorNum`,`codeLinesNum`,`mostWrittenIn`,`commentsPercentage`,`codebaseStatus`,`teamScale`,`commitStatus`,`estimateEffortTime`,`firstCommitTime`,`lastCommitTime`,`languagePercentages`,`activityDayTime`,`dayActivityInfos`,`daysCommitNumber`,`daysContributorNumber`,`newContributor`,`newContriNum`,`activityMonthTime`,`monthsCommitNumber`,`theCommitTrend`,`theContriTrend`,`rateLevel";
		String[] s = sss.split("`,`");
		System.out.println(s.length+"**********************************************");
		String ddd = "name},{activity},{useCount},{description},{tags},{organization},{projectLinks},{codeLocation},{licenses},{similarProjects},{managers},{commitNum},{contributorNum},{codeLinesNum},{mostWrittenIn},{commentsPercentage},{codebaseStatus},{teamScale},{commitStatus},{estimateEffortTime},{firstCommitTime},{lastCommitTime},{languagePercentages},{activityDayTime},{dayActivityInfos},{daysCommitNumber},{daysContributorNumber},{newContributor},{newContriNum},{activityMonthTime},{monthsCommitNumber},{monthsContributorNumber},{theCommitTrend},{theContriTrend},{rateLevel"; 
		String[] dsd = ddd.split("\\},\\{");
		System.out.println(dsd.length);
		
//			if(s[i]!=dsd[i]){
//				System.out.println(i+"-"+s[i]+"-"+dsd[i]);
//				break;
//			}
	
		CarClassTest sd = new CarClassTest();
	}

}
