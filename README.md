# Database Simulator

## Overview

This project simulates a **database system** using a **B+ Tree** to store and manage data efficiently. The B+ Tree provides fast access to the data through tree-based searching, making it ideal for implementing indexing mechanisms in a database. This project demonstrates key database concepts such as table management, indexing, and tree operations like insertion, searching, and deletion.

## Key Concepts

1. **B+ Tree** 
   The B+ Tree is a balanced tree structure where each node can store multiple keys, and leaf nodes contain the actual data or pointers to data. This structure enables fast searching, insertion, and deletion operations.

   - **Insertion** : Adds new records to the database while maintaining the tree’s balance.
   - **Search** : Finds a record in the database by navigating through the tree.
   - **Deletion** : Removes records from the database and adjusts the tree structure to maintain balance.

2. **Database Table** 
   The project includes a simulation of a database table, which manages records and their associated indexes. This section is designed to handle various data types and supports adding, updating, and deleting records.

   - **Record Management** : Supports the insertion, deletion, and modification of records.
   - **Index Management** : Keeps track of records using the B+ Tree and helps in fast lookups.

3. **Indexing** 
   The project supports the creation of different types of indexes:
   - **Primary Index** : A unique index that ensures each record has a unique key.
   - **Unique Index** : Ensures no duplicate values for a given column.
   - **Non-Unique Index** : Allows multiple records with the same value in the indexed column.

## Features 

- **B+ Tree Operations** : Insertion, deletion, and search.
- **Table Management** : Record and index management within a database table.
- **Index Creation** : Support for primary, unique, and non-unique indexes for fast access.
- **Data Types** : Handling of different data types in the database.

## Usage 🛠️

1. **Setting Up the Database** 
   The database is initialized by creating tables and indexes. You can insert records and define primary or secondary indexes to improve data access.

2. **Inserting Records** 
   Records can be inserted into the database using the B+ Tree structure. Insertions will maintain the tree balance automatically.

3. **Searching Records** 
   To retrieve records, the project supports searching by key value. The B+ Tree structure ensures that searches are performed in logarithmic time, providing fast access to the desired records.

4. **Deleting Records** 
   Records can be deleted from the database, with the system handling the necessary tree rebalancing and index adjustments.

5. **Creating Indexes**  
   Users can create indexes for columns in a table, choosing between primary, unique, and non-unique types to optimize query performance.

## Conclusion

This project offers a simulation of a database management system using a **B+ Tree**, which is essential for understanding the basics of database indexing and tree-based data structures. It demonstrates the implementation of common tree operations and their application to database record management.
