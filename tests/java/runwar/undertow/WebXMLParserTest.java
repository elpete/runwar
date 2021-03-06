package runwar.undertow;

import static io.undertow.servlet.Servlets.deployment;
import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import io.undertow.servlet.api.DeploymentInfo;
import lucee.loader.servlet.CFMLServlet;

public class WebXMLParserTest {
    private DeploymentInfo deploymentInfo;
    CFMLServlet servlet;

    public WebXMLParserTest() {
        deploymentInfo = deployment()
                .setContextPath("")
                .setTempDir(new File(System.getProperty("java.io.tmpdir")))
                .setDeploymentName("test").setClassLoader(this.getClass().getClassLoader());
    }

    @BeforeClass
    public static void before(){
//        LogSubverter.subvertLoggers("TRACE");
    }
    
    @Test
    public void testCommandBoxLuceeWebXML() {
        File webxml = new File("tests/resource/xml/cmdbox/lucee4.web.xml");
        boolean ignoreWelcomePages = false;
        boolean ignoreRestMappings = false;
        WebXMLParser.parseWebXml(webxml, deploymentInfo, ignoreWelcomePages, ignoreRestMappings);
        assertEquals(2, deploymentInfo.getServlets().size());
    }


}
