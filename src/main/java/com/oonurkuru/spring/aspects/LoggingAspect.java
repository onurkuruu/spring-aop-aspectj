package com.oonurkuru.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Onur Kuru on 18.7.2017.
 */

/**
 * Advice tipleri olan before, after, around kullanımları aşağıda örneklenmiştir.
 * Her bir advice geliştirici tarafından yazılan pointcutlar yardımıyla join pointlere yerleştirilir.
 */
@Aspect
public class LoggingAspect {


    /**
     * Before advice belirtilen join pointten önce çalışır.
     * @param joinPoint
     */
    @Before("within(com.oonurkuru.spring.services.*)")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint.getSignature().getName() + " çalışmaya başladı!");
    }

    /**
     * After advice belirtilen join pointten sonra çalışır
     * @param joinPoint
     */
    @After("within(com.oonurkuru.spring.services.*)")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After: " + joinPoint.getSignature().getName() + " çalışması tamamlandı!");
    }

    /**
     * Eğer belirtilen join point te bir hata meydana gelirse bu advice çalışır.
     * @param joinPoint join point ile ilgili bilgilere ulaşılabilir.
     * @param error meydana gelen hataya bu parametre yardımıyla ulaşılabilir.
     */
    @AfterThrowing(pointcut = "within(com.oonurkuru.spring.services.*)", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("After Throwing: " + joinPoint.getSignature().getName() + " hata fırlattı!");
        System.out.println("Exception : " + error);
    }

    /**
     * Eğer belirtilen join point te bir hata meydana gelmezse bu advice çalışır.
     * @param joinPoint join point ile ilgili bilgilere ulaşılabilir.
     */
    @AfterReturning("within(com.oonurkuru.spring.services.*)")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("After Returning: " + joinPoint.getSignature().getName() + " çalışması tamamlandı!");
    }

    /**
     * Bu advice ilgili joint pointi sarmalar duruma göre join point kodlarını çalıştırabilir ya da çalıştırmaya biliriz.
     * @param joinPoint ProceedingJoinPoint tipinde olan parametre join point kodlarının çalıştırılması için proceed() fonksiyonu kullanılır.
     * @return
     * @throws Throwable
     */
    @Around("within(com.oonurkuru.spring.services.*)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around: " + joinPoint.getSignature().getName() + " çalışmaya başlamadan önce!");
        joinPoint.proceed();
        System.out.println("Around: " + joinPoint.getSignature().getName() + " çalışmayı tamamladı!");
        return joinPoint;
    }

}
