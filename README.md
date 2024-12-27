## Integer File Reader

Program reads numbers (primitive data types) from a text file and outputs summary statistics (ie., highest and lowest values, the average), and total numerical values processed. Ideal for analyzing large sets of numerical data without having to use complex spreadsheet software.

### Setup

```bash
fileReader/
├── README.md
├── data/
│   └── sampleFile.txt
├── lib/
└── src/
    ├── App.java
    └── IntegerFileReader.java
```

### Quick Start

**Clone the repository**
```bash
git clone https://github.com/yourusername/integer-file-analyzer.git
```

**Navigate to project directory**
```bash
cd integer-file-analyzer
```

**Compile**
```bash
javac src/IntegerFileReader.java
```

**Run with sample data**
```bash
java -cp src IntegerFileReader
```

### Features

- Stream-based file processing for optimal memory usage
- Statistical analysis (min, max, average, count)
- Error handling for malformed data
- Whitespace-agnostic parsing


### Performance Considerations

- O(n) time complexity where n is the number of lines in the input file
- Constant memory footprint regardless of input size
- Efficient string tokenization using regex pattern matching

### TODOs

- [ ] Implement multi-threading for parallel file processing
- [ ] Add support for configurable input/output formats (CSV, JSON)
- [ ] Integrate with logging framework (SLF4J)
- [ ] Implement command-line argument parsing
- [ ] Add unit tests and integration tests
- [ ] Containerize application with Docker


### Contributing

1. Fork the repository
2. Create a feature branch (git checkout -b feature/enhancement)
3. Commit changes (git commit -am 'Add enhancement')
4. Push to branch (git push origin feature/enhancement)
5. Open a Pull Request