(ns wharf.test-core
  (require [clojure.test :refer :all]
           [wharf.core :refer :all]))

(deftest test-capitalize
  (is (= "Hello" (capitalize "hello")))
  (is (= "HELLO" (capitalize "HELLO")))
  (is (= "HElLo" (capitalize "hElLo"))))

(deftest test-uncapitalize
  (is (= "hello" (uncapitalize "hello")))
  (is (= "hELLO" (uncapitalize "HELLO")))
  (is (= "hElLo" (uncapitalize "HElLo"))))

(deftest test-hyphen->upper-camel
  (is (empty? (hyphen->upper-camel "")))
  (is (= "A" (hyphen->upper-camel "a")))
  (is (= "Foo" (hyphen->upper-camel "foo")))
  (is (= "FooBar" (hyphen->upper-camel "foo-bar")))
  (is (= "IFoo" (hyphen->upper-camel "i-foo")))
  (is (= "AB" (hyphen->upper-camel "a-b"))))

(deftest test-hyphen->lower-camel
  (is (empty? (hyphen->lower-camel "")))
  (is (= "a" (hyphen->lower-camel "a")))
  (is (= "foo" (hyphen->lower-camel "foo")))
  (is (= "fooBar" (hyphen->lower-camel "foo-bar")))
  (is (= "iFoo" (hyphen->lower-camel "i-foo")))
  (is (= "aB" (hyphen->lower-camel "a-b"))))

(deftest test-camel->hyphen
  (is (empty? (camel->hyphen "")))
  (is (= "a" (camel->hyphen "a")))
  (is (= "foo" (camel->hyphen "foo")))
  (is (= "Foo-Bar" (camel->hyphen "FooBar")))
  (is (= "foo-Bar" (camel->hyphen "fooBar")))
  (is (= "I-Foo" (camel->hyphen "IFoo")))
  (is (= "SQL-Foo" (camel->hyphen "SQLFoo")))
  (is (= "foo1-Bar" (camel->hyphen "foo1Bar")))
  (is (= "Foo-No1se" (camel->hyphen "FooNo1se"))))

(deftest test-camel-sticky->hyphen
  (is (empty? (camel-sticky->hyphen "")))
  (is (= "a" (camel-sticky->hyphen "a")))
  (is (= "foo" (camel-sticky->hyphen "foo")))
  (is (= "Foo-Bar" (camel-sticky->hyphen "FooBar")))
  (is (= "foo-Bar" (camel-sticky->hyphen "fooBar")))
  (is (= "IFoo" (camel-sticky->hyphen "IFoo")))
  (is (= "OAuth-Foo" (camel-sticky->hyphen "OAuthFoo")))
  (is (= "foo1-Bar" (camel-sticky->hyphen "foo1Bar")))
  (is (= "Foo-No1se" (camel-sticky->hyphen "FooNo1se"))))

(deftest test-camel->underscore
  (is (empty? (camel->underscore "")))
  (is (= "a" (camel->underscore "a")))
  (is (= "foo" (camel->underscore "foo")))
  (is (= "Foo_Bar" (camel->underscore "FooBar")))
  (is (= "foo_Bar" (camel->underscore "fooBar")))
  (is (= "I_Foo" (camel->underscore "IFoo")))
  (is (= "SQL_Foo" (camel->underscore "SQLFoo")))
  (is (= "foo1_Bar" (camel->underscore "foo1Bar")))
  (is (= "Foo_No1se" (camel->underscore "FooNo1se"))))

(deftest test-camel-sticky->underscore
  (is (empty? (camel-sticky->underscore "")))
  (is (= "a" (camel-sticky->underscore "a")))
  (is (= "foo" (camel-sticky->underscore "foo")))
  (is (= "Foo_Bar" (camel-sticky->underscore "FooBar")))
  (is (= "foo_Bar" (camel-sticky->underscore "fooBar")))
  (is (= "IFoo" (camel-sticky->underscore "IFoo")))
  (is (= "OAuth_Foo" (camel-sticky->underscore "OAuthFoo")))
  (is (= "foo1_Bar" (camel-sticky->underscore "foo1Bar")))
  (is (= "Foo_No1se" (camel-sticky->underscore "FooNo1se"))))

(deftest test-hyphen->underscore
  (is (empty? (hyphen->underscore "")))
  (is (= "a" (hyphen->underscore "a")))
  (is (= "foo" (hyphen->underscore "foo")))
  (is (= "123" (hyphen->underscore "123")))
  (is (= "foo_bar" (hyphen->underscore "foo_bar")))
  (is (= "FOO_BAR" (hyphen->underscore "FOO-BAR")))
  (is (= "foo_bar_baz" (hyphen->underscore "foo-bar-baz")))
  (is (= "foo1_bar" (hyphen->underscore "foo1-bar")))
  (is (= "foo_no1se" (hyphen->underscore "foo-no1se"))))

(deftest test-underscore->hyphen
  (is (empty? (underscore->hyphen "")))
  (is (= "a" (underscore->hyphen "a")))
  (is (= "foo" (underscore->hyphen "foo")))
  (is (= "123" (underscore->hyphen "123")))
  (is (= "foo-bar" (underscore->hyphen "foo_bar")))
  (is (= "FOO-BAR" (underscore->hyphen "FOO_BAR")))
  (is (= "foo-bar-baz" (underscore->hyphen "foo_bar_baz")))
  (is (= "foo1-bar" (underscore->hyphen "foo1_bar")))
  (is (= "foo-no1se" (underscore->hyphen "foo_no1se"))))
