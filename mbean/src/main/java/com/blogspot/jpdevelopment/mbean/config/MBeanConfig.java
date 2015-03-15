package com.blogspot.jpdevelopment.mbean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Lazy;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;
import org.springframework.jmx.export.assembler.MetadataMBeanInfoAssembler;
import org.springframework.jmx.export.naming.MetadataNamingStrategy;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;
import org.springframework.jmx.support.RegistrationPolicy;

import javax.management.MBeanServerConnection;
import java.io.IOException;

@Configuration
@ComponentScan("com.blogspot.jpdevelopment.mbean")
@EnableMBeanExport(registration = RegistrationPolicy.REPLACE_EXISTING)
public class MBeanConfig {

//    @Bean
//    @Lazy(false)
//    public AnnotationMBeanExporter annotationMBeanExporter() {
//        return new AnnotationMBeanExporter();
//    }

    @Bean
    @Lazy(false)
    public MBeanExporter getExporter() {
        MBeanExporter exporter = new MBeanExporter();
        exporter.setAutodetect(true);
        exporter.setRegistrationPolicy(RegistrationPolicy.REPLACE_EXISTING);
        exporter.setNamingStrategy(getNamingStrategy());
        exporter.setAssembler(getMbeanInfoAssembler());
        return exporter;
    }

    @Bean
    public MetadataNamingStrategy getNamingStrategy() {
        MetadataNamingStrategy strategy = new MetadataNamingStrategy();
        strategy.setAttributeSource(new AnnotationJmxAttributeSource());
        return strategy;
    }

    @Bean
    public MetadataMBeanInfoAssembler getMbeanInfoAssembler() {
        return new MetadataMBeanInfoAssembler(new AnnotationJmxAttributeSource());
    }

//    @Autowired
//    private SpringHelloWorldMBean springHelloWorldMBean;

//    @Bean
//    public MBeanExporter exporter(SpringHelloWorldMBean springHelloWorldMBean) {
//        MBeanExporter mBeanExporter = new MBeanExporter();
//        mBeanExporter.setBeans((Map<String, Object>) new HashMap<>().put("bean:name=SpringHelloWorldMBean", springHelloWorldMBean));
//
//        return mBeanExporter;
//    }

    @Bean
    public MBeanServerConnection clientConnector() throws IOException {
        final MBeanServerConnectionFactoryBean mBeanServerConnectionFactoryBean = new MBeanServerConnectionFactoryBean();
        return mBeanServerConnectionFactoryBean.getObject();
    }

//    @Bean
//    public ConnectorServerFactoryBean connectorServerFactoryBean() {
//        return new ConnectorServerFactoryBean();
//    }
}
