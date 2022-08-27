{\rtf1\ansi\ansicpg949\cocoartf2639
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset129 AppleSDGothicNeo-Regular;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 import java.util.*;\
class Solution \{\
    public int solution(int[] queue1, int[] queue2) \{\
        int answer = -2;\
        Queue<Integer> que1 = new LinkedList<>();\
        Queue<Integer> que2 = new LinkedList<>();\
        long sum1= 0; long sum2 = 0;\
\
        for(int i=0; i<queue1.length; i++)\{\
            sum1 += queue1[i];\
            que1.offer(queue1[i]);\
        \}\
\
        for(int i=0; i<queue2.length; i++)\{\
            sum2 += queue2[i];\
            que2.offer(queue2[i]);\
        \}\
\
        int count = 0;\
        while(sum1 != sum2)\{\
            count++;\
\
            if(sum1> sum2)\{\
                int value = que1.poll();\
                sum1 -= value;\
                sum2 += value;\
                que2.offer(value);\
            \}else\{\
                int value = que2.poll();\
                sum1 += value;\
                sum2 -= value;\
                que1.offer(value);\
            \}\
\
            if(count > (queue1.length + queue2.length) * 2) return -1; //
\f1 \'c1\'a4\'b4\'e4
\f0  
\f1 \'c1\'b8\'c0\'e7
\f0  X\
        \}\
        \
        answer = count;\
        return answer;\
    \}\
\}}