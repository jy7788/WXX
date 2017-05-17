package com.cn.hnust.util;

import java.security.SecureRandom;
import java.util.Random;
/**
*	@author MjrTom
*	2006/Jan/02:	added various methods, including some java.util.Random method aliases 
*/
public class 
RandomUtils 
{
public static final Random RANDOM = new Random( System.currentTimeMillis() );
public static final SecureRandom SECURE_RANDOM = new SecureRandom();
/**
* Generate a random array of bytes.
* @param num_to_generate number of bytes to generate
* @return random byte array
*/
public static byte[] generateRandomBytes( int num_to_generate ) {
   byte[] id = new byte[ num_to_generate ];
   RANDOM.nextBytes( id );    
   return id;
 }
/**
* Generate a random string of charactors.
* @param num_to_generate number of chars to generate
* @return random char string
*/
public static String generateRandomAlphanumerics( int num_to_generate ) {
String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
StringBuffer buff = new StringBuffer( num_to_generate );
   for( int i=0; i < num_to_generate; i++ ) {
   	int pos = (int)( RANDOM.nextDouble() * alphabet.length() );
   	buff.append( alphabet.charAt( pos ) );
   }
   
   return buff.toString();
 }
public static final int LISTEN_PORT_MIN = 10000;
public static final int LISTEN_PORT_MAX = 65535;
/**
* Generate a random port number for binding a network IP listening socket to.
* NOTE: Will return a valid non-privileged port number >= LISTEN_PORT_MIN and <= LISTEN_PORT_MAX.
* @return random port number
*/
/**
* Generates a random +1 or -1
* @return +1 or -1
*/
public static int generateRandomPlusMinus1()
{
return RANDOM.nextBoolean() ? -1:1;
}
public static float nextFloat()
{
return RANDOM.nextFloat();
}
   public static void nextBytes(byte[] bytes)
{
   	RANDOM.nextBytes(bytes);
}
   
   public static void nextSecureBytes( byte[] bytes )
   {
   	SECURE_RANDOM.nextBytes( bytes );
   }
   
   public static byte[] nextSecureHash()
   {
   	byte[] hash = new byte[20];
   
   	SECURE_RANDOM.nextBytes( hash );
   
   	return( hash );
   }
   
   public static byte[] nextHash()
   {
   	byte[] hash = new byte[20];
   
   	RANDOM.nextBytes( hash );
   
   	return( hash );
   }
   
   public static int nextInt(int n)
{
   	return RANDOM.nextInt(n);
}
   
   public static byte nextByte()
   {
       return (byte)RANDOM.nextInt();
   }
       
   public static int nextInt()
   {
       return RANDOM.nextInt();
   }
       
   public static long nextLong()
   {
       return RANDOM.nextLong();
   }
       
/**
* @return random int between 0 and max-1. e.g. param of 10 returns 0->9
*/
public static int generateRandomIntUpto(int max)
{
return nextInt(max);
}
/**
* @return random int between min and max, e.g params of [5,7] returns 5,6 or 7
*/
public static int generateRandomIntBetween(int min, int max)
{
return min +generateRandomIntUpto(max + 1 - min);
}
}