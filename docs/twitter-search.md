# Twitter Search

## API

``` search(String searchTerms) ```

## Search Parser

- Parse the text into a list of keywords

## Search operation

- Search index based on keywords
- Index is a map of keywords as keys

## Index

- Map<String, List<Doc>>

## Index Loader

- Parse database records/tweet
- Create an inverted index with keywords as keys

## Database

```
tweetId: 12345
tweetText: The life is beautiful.
```

### tweetId generator

- UUID
- epoc + number generator

### hash: tweetId vs database instance

Dynamic mapping

1. Map between tweet id and database instance id.
1. Map a range between tweet id and database instance id.

Static mapping

1. Include database instance with id in tweet id.
1. Consistent hashing to retrieve database instance id from tweet id.
`SortedMap<Long, VirtualNode<T>>`
`sm.get("tweet_id") -> virtual node`   

## Scalable System Design

### Data

- 300 bytes for each tweet and 10 bytes tweet id
- 500 M tweets/day
- 150 GB/day => 50 TB/yr => 250 TB/yr
- Fault tolerance 500 TB/yr
- 4 TB for each system => 120 systems

### Performance

### Fault tolerance
