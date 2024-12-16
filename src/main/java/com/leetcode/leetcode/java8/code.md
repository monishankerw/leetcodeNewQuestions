

                       // 10.package com.decendingorder;
                        public static class DecendingNumber {
                            public static void main(String strs[]) {
                                List<Integer>number=Arrays.asList(21,2,23,4,25,26,17,8);

                                List<Integer>num=number.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
                                System.out.println(num);

                            }
                        }

package accendingorder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

                        public class AccendngOrder {
                            public static void main(String[] args) {
                                List<Integer> num = Arrays.asList(2,4,1,3,6,7,5,9,8);
                                System.out.println("Orginal Number:"+num);
                                List<Integer> num1 = num.stream().sorted().collect(Collectors.toList());
                                System.out.println("Accending Order:"+num1);
                            }
                        }
                        11.package com.evennuber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


                        public class SumEvenNumber {
                            public static void main(String strs[]) {
                                List<Integer>number=Arrays.asList(1,2,3,4,5,6,7,8);

                                Comparable<Integer>num=number.stream().filter(n->n%2==0).reduce(0,(ans,i)->ans+i);
                                System.out.println("Enter The Even number Number is:"+num);
                            }
                        }

                        12. package com.squrenumber;
                        public class SumEvenNumber {
                            public static void main(String strs[]) {
                                List<Integer>number=Arrays.asList(1,2,3,4,5,6,7,8);

                                Comparable<Integer>num=number.stream().map(n->n*n).collect(Collectors.toList());
                                System.out.println("Enter The Even number Number is:"+num);
                            }
                        }
                        13. package com.squrenumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

                        public class SumEvenNumber {
                            public static void main(String strs[]) {
                                List<Integer>number=Arrays.asList(1,2,3,4,5,6,7,8);

                                List<Integer>num=number.stream().map(n->n*n).collect(Collectors.toList());
                                System.out.println("Enter The Even number Number is:"+num);
                            }
                        }
                        14.package com.starwith;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

                        public class SumEvenNumber {
                            public static void main(String strs[]) {
                                List<String>str=Arrays.asList("Reflection","Collection","stream");

                                List<String> a = str.stream().filter(s->s.startsWith("s")).collect(Collectors.toList());
                                System.out.println("Enter The String is:"+a);
                            }
                        }

                        15.package com.startingwithnumber;
                        public class A{
                            public static void main(String strs[]) {
                                List<Integer>n=Arrays.asList(1233,255,453,442,5567,54322,76887,56);
                                n.stream().filter(s->s.startswith("1")).forEach(System.out::println));
                            }
                        }

package com.streamapi;

import java.util.Arrays;
import java.util.List;

                        public class NumberStartingWith2 {
                            public static void main(String[] args) {
                                List<Integer>num=Arrays.asList(20,14,25,26,27,29);
                                num.stream().map(s->s+"").filter(s->s.startsWith("2")).forEach(System.out::println);
                            }
                        }
                        17.package abc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

                        public class DuplicateElements {
                            public static void main(String args[]) {
                                List<Integer>a=new ArrayList<>(Arrays.asList(1,2,3,1,2,4,3,5,6,4,5,4,5));
                                System.out.println("Duplicate Elements:"+a);
                                Set<Integer>set=new LinkedHashSet<>();
                                set.addAll(a);
                                a.clear();
                                a.addAll(set);
                                System.out.println("WithoutDuplicate Elements:"+a);

                            }}