# Secret Santa.
REST API service that chooses a [Secret Santa](https://en.wikipedia.org/wiki/Secret_Santa) for all teammates.

# Requirements.
 - A person cannot be their own Secret Santa.
 - A person can only be the same other person’s Secret Santa once every three years.

# Implementation
Solved using graph theory by constructing directed graph with all possible edges between santas and receivers and finding Hamiltonian path in it.
