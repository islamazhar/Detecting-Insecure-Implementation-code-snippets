# Making Sense of Online Code Snippets
Developers frequently reuse existing libraries and frame-
works while creating new systems
Stack Overflow 1 is one popular web site to
look for such usage examples
It is common to encounter
posts on Stack Overflow that contain source code snippets
that demonstrate a solution to a particular programming task
or the usage of a specific API
Stack Overflow also lets users
annotate the best solution to a question based on whether the
answer helped them with their original problem. This metadata
provides insight into the quality and correctness of the code
included in these answers

Stack Overflow treats source code snippets as plain
text and searches surface snippets as they would any other text
<!-- Hence can not detect if vulnerable patterns are there or not -->

# Secure Coding Practices in Java: Challenges and Vulnerabilities

Developers have pragmatic goals (i.e., getting the code to run)
and security goals.

Some of the choices made by developers
indicate that the pragmatic goals can take priority over security, if a
developer cannot satisfy both of them.
In addition, cybersecurity
decisions may be influenced by the social factors (such as reputa-
tion scores, votes, and accept labels) on the StackOverflow forum.

We also found one instance of cyberbullying, where condescending
comments were directed at a security-conscious user [103].

# Stack Overflow Considered Harmful? The Impact of Copy&Paste on Android Application Security
programming discussion platforms such as
Stack Overflow serve as a rich source of information for software
developers. Available information include vibrant discussions
and oftentimes ready-to-use code snippets. Previous research
identified Stack Overflow as one of the most important in-
formation sources developers rely on. Anecdotes report that
software developers copy and paste code snippets from those
information sources for convenience reasons. Such behavior
results in a constant flow of community-provided code snippets
into production software. To date, the impact of this behaviour
on code security is unknown.

We answer this highly important question by quantifying
the proliferation of security-related code snippets from Stack
Overflow in Android applications available on Google Play.
Access to the rich source of information available on Stack
Overflow including ready-to-use code snippets provides huge
benefits for software developers. However, when it comes to
code security there are some caveats to bear in mind: Due
to the complex nature of code security, it is very difficult to
provide ready-to-use and secure solutions for every problem.
Hence, integrating a security-related code snippet from Stack
Overflow into production software requires caution and expertise.
Unsurprisingly, we observed insecure code snippets being copied
into Android applications millions of users install from Google
Play every day. 

## Introduction
Discussion platforms for software developers have grown in
popularity. Especially inexperienced programmers treasure the
direct help from the community providing easy guide and most
often even ready-to-use code snippets. It is widely believed
that copying such code snippets into production software is
generally practiced not only by the novice but by large parts
of the developer community. Access to the rich source of
information given by public discussion platforms provides
quick solutions. This allows fast prototyping and an efficient
workflow. Further, the public discussions by sometimes ex-
perienced developers potentially promote distribution of best-
practices and may improve code quality on a large basis.

However, when it comes to code security, we often observe
the opposite. Android-related discussions on Stack Overflow
for example include an impressive conglomeration of oddities:
from requesting too many and unneeded permissions [1]
to implementing insecure X.509 certificate validation [2] to
misusing Android’s cryptographic API [3], a developer who is
seeking help can find solutions for almost any problem. While
such solutions oftentimes provide functional code snippets,
many of them threaten code security. Those insecure code
snippets commonly have a rather solid life-cycle: provided by
the community, copied and pasted by the developer, shipped
to the customer, and exploited by the attacker. To date it is
unknown to what extent software developers copy and paste
code snippets from information sources into production soft-
ware. Is this phenomenon limited to just occasional instances,
or is it rather a general and dangerous trend threatening code
security to a large extent?

# Snakes in Paradise?: Insecure Python-related Coding Practices in Stack Overflow

Despite being the most popular question and an-
swer website for software developers, answers posted on Stack
Overflow (SO) are susceptible to contain Python-related insecure
coding practices. A systematic analysis on how frequently inse-
cure coding practices appear in SO answers can help the SO
community assess the prevalence of insecure Python code blocks
in SO. An insecure coding practice is recurrent use of insecure
coding patterns in Python. We conduct an empirical study using
529,054 code blocks collected from Python-related 44,966 answers
posted on SO. We observe 7.1% of the 44,966 Python-related
answers to include at least one insecure coding practice. The most
frequently occurring insecure coding practice is code injection.
We observe 9.8% of the 7,444 accepted answers to include at
least one insecure code block. We also find user reputation not
to relate with the presence of insecure code blocks, suggesting
that both high and low-reputed users are likely to introduce
insecure code blocks.

## Introduction:
Stack Overflow (SO) is regarded as the most popular
question and answer website for software developers [1].
How software developers use and contribute to SO posts
for software projects [2] [3] [4], and the technologies and
tools [5] [6] they refer to, has drawn interest of researchers.

Despite SO’s popularity, answers posted on SO are suscepti-
ble to contain code blocks which include insecure coding prac-
tices. Let us consider Figure 1 as an example in this regard.
In Figure 1 we present an accepted answer posted on SO [7]
related to hash calculation in Python. The answer proposes
the use of MD5 to compute hash using the ‘hashlib.md5()’
method. Use of MD5 is insecure, as MD5 is susceptible
to collision attacks. The National Institute of Standard and
Technologies (NIST) recommends against the use of MD5 [8].
A software developer who wants to implement hash in Python
and comes across this answer may use the provided code
block, unintentionally leaving a security weakness in the
software code. We take motivation from the provided code
block in Figure 1, and investigate the prevalence of insecure
coding practices in SO answers related to Python, which IEEE
Spectrum ranked as the top-most programming language for
the year 2018 [9].
    
We conduct our empirical study to systematically quantify
the prevalence of insecure coding practices i.e. recurrent use of
insecure coding patterns in Python. We answer the following
research questions