# Social Reading Tracker Requirements and Implementation Plan

This project is a backend-first social reading app. Users will keep a personal record of books they want to read, are currently reading, and have finished; connect with friends; and share reviews and comments. The plan keeps the existing Java, Spring Boot, Maven, and PostgreSQL stack. The API is the initial focus; a frontend is a later phase.

The phases are ordered so each can be implemented and exercised before building on it. Complete tasks within a phase in order, and defer optional features until the core workflow works.

## Phase 0: Project Foundation

- [x] 0.1 Create a Spring Boot project with Java and Maven
- [x] 0.2 Add Spring Web, Spring Data JPA, Validation, PostgreSQL, and Lombok dependencies
- [x] 0.3 Configure application profiles for development and test
- [x] 0.4 Add a `.gitignore` for Java, Maven, IDE, and environment files
- [x] 0.5 Add a basic health endpoint
- [x] 0.6 Create the initial package structure
- [x] 0.7 Write a README with project goals and local setup instructions

## Phase 1: Agree on the API and Data Foundations

- [ ] 1.1 Define controller, service, repository, entity, DTO, mapper, and exception responsibilities
- [ ] 1.2 Keep API request/response models separate from persistence entities
- [ ] 1.3 Define a consistent success and error response format
- [ ] 1.4 Add global exception handling with `@RestControllerAdvice`
- [ ] 1.5 Add request validation with clear validation messages
- [ ] 1.6 Choose and document database migration tooling (Flyway or Liquibase)
- [ ] 1.7 Replace the legacy issue-tracking schema with an initial migration for users, books, personal shelves, friendships, reviews, and comments
- [ ] 1.8 Define relationships and uniqueness rules, including one shelf entry per user and book, and one review per shelf entry
- [ ] 1.9 Define privacy and authorization rules for profiles, shelves, reviews, and comments
- [ ] 1.10 Define shared conventions for timestamps, identifiers, and API versioning

## Phase 2: Register and Authenticate Readers

**User flow:** A person creates an account, logs in, and manages their reader profile.

- [ ] 2.1 Create the user model with name, unique email, password hash, and timestamps
- [ ] 2.2 Hash passwords; never store or return plaintext passwords
- [ ] 2.3 Add registration, login, and current-user endpoints
- [ ] 2.4 Protect private endpoints and define authorization rules
- [ ] 2.5 Return safe user DTOs that exclude password hashes and other security data
- [ ] 2.6 Allow users to view and update their profile
- [ ] Test registration, login, invalid credentials, token handling, profile updates, and authorization

## Phase 3: Find Books and Build a Personal Shelf

**User flow:** A reader finds a book, saves it to their shelf, and tracks its reading status.

- [ ] 3.1 Create a shared book model with title, author or authors, description, publication details, and an optional cover image URL
- [ ] 3.2 Add endpoints to create, retrieve, search, and browse books
- [ ] 3.3 Define how duplicate books are detected and handled
- [ ] 3.4 Create a personal shelf entry linking a reader to a book
- [ ] 3.5 Support statuses: `WANT_TO_READ`, `READING`, `READ`, and `DID_NOT_FINISH`
- [ ] 3.6 Add endpoints to add a book to a shelf, change its status, retrieve shelf entries, and remove an entry
- [ ] 3.7 Support filtering shelves by status, sorting, and pagination
- [ ] 3.8 Test book search, duplicate handling, shelf changes, and invalid status values

## Phase 4: Connect with Friends

**User flow:** A reader sends a friend request, the recipient accepts or declines it, and friends can discover each other's permitted reading activity.

- [ ] 4.1 Create a friendship model with requester, recipient, status, and timestamps
- [ ] 4.2 Support sending, accepting, declining, and cancelling requests, and removing friends
- [ ] 4.3 Prevent duplicate, self-directed, and conflicting friend requests
- [ ] 4.4 Add endpoints to find readers and view pending requests and a user's friends
- [ ] 4.5 Enforce friendship and profile privacy rules on every relevant endpoint
- [ ] Test friendship lifecycle, duplicate requests, and access by non-friends

## Phase 5: Share Reading Activity and Discuss Books

**User flow:** A reader writes a review for a book on their shelf, and friends can read and comment on activity they are allowed to see.

- [ ] 5.1 Allow a reader to create, edit, retrieve, and delete their review for a shelf entry
- [ ] 5.2 Support an optional rating and written review
- [ ] 5.3 Allow readers to comment on visible shelf entries and reviews
- [ ] 5.4 Record comment authors and creation times; allow authors to edit or delete their own comments
- [ ] 5.5 Support public, friends-only, and private visibility for shelf activity
- [ ] 5.6 Enforce visibility consistently for book activity, reviews, and comments
- [ ] 5.7 Add pagination to review and comment lists
- [ ] Test review ownership, comment permissions, privacy boundaries, and list pagination

## Phase 6: Make the API Reliable and Ready to Use

- [ ] 6.1 Define service-layer transaction boundaries
- [ ] 6.2 Ensure `updated_at` is refreshed consistently on updates
- [ ] 6.3 Add indexes for common lookups, including book titles, user shelves, friendship relationships, and comments
- [ ] 6.4 Use UTC consistently for date/time values
- [ ] 6.5 Add request correlation IDs and useful application logging
- [ ] 6.6 Add unit, controller, repository, and PostgreSQL-compatible integration tests for core behavior
- [ ] 6.7 Review API responses and authorization rules for accidental data exposure
- [ ] 6.8 Add OpenAPI documentation and example requests/responses
- [ ] 6.9 Add a Postman or Bruno collection
- [ ] 6.10 Complete Docker Compose setup for the API and PostgreSQL, with configuration for secrets supplied through the environment
- [ ] Document architecture, tradeoffs, and local setup in the README

## Phase 7: Build a Minimal Frontend

Start this phase after the API workflows are stable and documented.

- [ ] 7.1 Choose a minimal client approach
- [ ] 7.2 Add registration, login, and profile editing
- [ ] 7.3 Add book search and book details
- [ ] 7.4 Add a personal shelf with reading-status filters
- [ ] 7.5 Add friend search, requests, and friend lists
- [ ] 7.6 Add reviews and comments on visible reading activity
- [ ] 7.7 Use the frontend to exercise the same privacy and authorization rules as the API

## Optional Features

Consider these after the core reading and friendship workflows are complete.

- [ ] Add notifications for friend requests, comments, and reviews
- [ ] Add reading goals, progress tracking, and reading statistics
- [ ] Add book lists or recommendations shared with friends
- [ ] Add external book-catalog integration
- [ ] Add content reporting and moderation tools

## End-to-End Definition of Done

- [ ] The application can be started locally using documented commands
- [ ] A reader can register, log in, and manage their profile
- [ ] A reader can find a book and add it to their shelf as wanted, reading, read, or did not finish
- [ ] A reader can connect with another reader through friend requests
- [ ] A reader can review a book on their shelf and comment on activity they are allowed to see
- [ ] Private and friends-only reading activity is not exposed to unauthorized users
- [ ] Book, shelf, review, and comment lists support the documented filters and pagination
- [ ] Core behavior is covered by automated tests and documented through OpenAPI
- [ ] The repository contains no secrets, and the README explains architecture, tradeoffs, and local setup
