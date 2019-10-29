package org.drools.shihu.learn.rules.lhs;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class LhsMain {
	
	public static void main(String[] args) {
		KieServices ks = KieServices.get();
        KieContainer kc = ks.getKieClasspathContainer();

        execute( ks, kc );
	}
	
	
	public static void execute( KieServices ks, KieContainer kc ) {
        // From the container, a session is created based on
        // its definition and configuration in the META-INF/kmodule.xml file
        KieSession ksession = kc.newKieSession("lhs");
        //ksession.setGlobal( "list", new ArrayList<Object>() );

        // The application can also setup listeners
        ksession.addEventListener( new DebugAgendaEventListener() );
        ksession.addEventListener( new DebugRuleRuntimeEventListener() );

        // Set up a file based audit logger
        KieRuntimeLogger logger = ks.getLoggers().newFileLogger( ksession, "./lhs" );

        // To set up a ThreadedFileLogger, so that the audit view reflects events whilst debugging,
        // uncomment the next line
        // KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );

        // The application can insert facts into the session
        
        /*
        // and or test
        Customer customer = new Customer();
        customer.setCity("bj");
        ksession.insert(customer);
        Account account = new Account();
        account.setName("shihu");
        ksession.insert(account);
        */
        
        /*
        // exists test
        Customer customer = new Customer();
        ksession.insert(customer);
        */
        
//        // not test
//        Customer customer = new Customer();
//        ksession.insert(customer);
        
        /*
        // from element test
        Account a1 = new Account();
        a1.setName("a1");
        Account a2 = new Account();
        a2.setName("a1");
        Customer from = new Customer();
        from.getAccounts().add(a1);
        from.getAccounts().add(a2);
        ksession.insert(from);
        */
        
        /*
        //collect element test
        Account a1 = new Account();
        a1.setStatus("Y");
        ksession.insert(a1);
        
        Account a2 = new Account();
        a2.setStatus("Y");
        ksession.insert(a2);
        
        Customer customer = new Customer();
        ksession.insert(customer);
        */
        
        /*
        // accumulate element test
        Account a1 = new Account();
        a1.setNum(100);
        ksession.insert(a1);
        
        Account a2 = new Account();
        a2.setNum(1000);
        ksession.insert(a2);
        */
        
        /*
        // 字段约束连接
        Customer customer = new Customer();
        customer.setName("shihu");
        Account account1 = new Account();
        Account account2 = new Account();
        customer.getAccounts().add(account1);
        customer.getAccounts().add(account2);
        ksession.insert(customer);
        account1.setName("yanyi");
        ksession.insert(account1);
        */
        
        /*
        //比较操作符-memberof
        Customer customer = new Customer();
        Account account1 = new Account();
        customer.getAccounts().add(account1);
        ksession.insert(customer);
        ksession.insert(account1);
        */
        
        // matches 正则表达式匹配
        Customer customer = new Customer();
        customer.setCity("ubj");
        Customer customer2 = new Customer();
        customer2.setCity("ush_helo");
        ksession.insert(customer);
        ksession.insert(customer2);
        
        
        
        
        // and fire the rules
        ksession.fireAllRules();
        logger.close();
        ksession.dispose();
    }

}
